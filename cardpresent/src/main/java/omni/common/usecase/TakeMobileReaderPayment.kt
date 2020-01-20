package omni.common.usecase

import omni.common.data.*
import omni.common.data.models.*
import omni.common.data.repository.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.*
import kotlinx.serialization.stringify
import omni.common.data.MobileReaderDriver
import omni.common.data.TransactionRequest
import omni.common.data.TransactionResult
import omni.common.data.models.*
import omni.common.data.repository.*
import kotlin.coroutines.CoroutineContext

class TakeMobileReaderPayment(
        val mobileReaderDriverRepository: MobileReaderDriverRepository,
        val invoiceRepository: InvoiceRepository,
        val customerRepository: CustomerRepository,
        val paymentMethodRepository: PaymentMethodRepository,
        val transactionRepository: TransactionRepository,
        val request: TransactionRequest,
        override val coroutineContext: CoroutineContext
) : CoroutineScope {

    class TakeMobileReaderPaymentException(message: String? = null) :
        OmniException("Could not take mobile reader payment", message)

    suspend fun start(onError: (OmniException) -> Unit): Transaction? = coroutineScope {

        // Get the reader responsible for taking the payment
        val reader = getAvailableMobileReaderDriver(mobileReaderDriverRepository)
        if (reader == null) {
            onError(TakeMobileReaderPaymentException("No available mobile reader"))
            return@coroutineScope null
        }

        // Create invoice
        val invoice: Invoice = invoiceRepository.create(
            Invoice().apply {
                total = request.amount.dollarsString()
                url = "https://qa.fattpay.com/#/bill/"

                val invoiceMeta: Map<String, JsonElement> = mapOf(
                        "subtotal" to JsonPrimitive(request.amount.dollarsString())
                )

                meta = JsonObject(invoiceMeta)
            }
        ) {
            onError(it)
        } ?: return@coroutineScope null

        // Take the mobile reader payment
        val result: TransactionResult

        try {
            result = reader.performTransaction(request)
        } catch (e: MobileReaderDriver.PerformTransactionException) {
            onError(TakeMobileReaderPaymentException(e.detail))
            return@coroutineScope null
        } catch (e: Error) {
            // Something went wrong while performing the transaction
            onError(TakeMobileReaderPaymentException(e.message))
            return@coroutineScope null
        }

        val cardLastFour = try {
            result.maskedPan?.substring(result.maskedPan!!.lastIndex - 3) ?: "****"
        } catch (e: Error) {
            "****"
        }

        // Create customer
        val customer = customerRepository.create(
            Customer().apply {
                firstname = result.cardHolderFirstName ?: "SWIPE"
                lastname = result.cardHolderLastName ?: "CUSTOMER"
            }
        ) {
            onError(it)
        } ?: return@coroutineScope null

        // Create a PaymentMethod
        val paymentMethod = paymentMethodRepository.create(
            PaymentMethod().apply {
                merchantId = customer.merchantId
                customerId = customer.id
                method = "card"
                cardType = result.cardType
                this.cardLastFour = cardLastFour
                personName = (customer.firstname ?: "") + " " + (customer.lastname ?: "")
                tokenize = false
            }
        ) {
            onError(it)
        } ?: return@coroutineScope null

        // Associate payment method and invoice with customer
        invoice.paymentMethodId = paymentMethod.id
        invoice.customerId = customer.id

        // Update invoice
        invoiceRepository.update(invoice) {
            onError(it)
        } ?: return@coroutineScope null

        // Create transaction
        val transactionMeta = json {
            "nmiUserRef" to JsonPrimitive(result.userReference)
        }

        var gatewayResponse: JsonObject? = null

        result.authCode?.let { authCode ->
            val responseMap = json {
                "gateway_specific_response_fields" to json {
                    "nmi" to json {
                        "authcode" to JsonPrimitive(authCode)
                    }
                }
            }

            gatewayResponse = responseMap
        }

        transactionRepository.create(
            Transaction().apply {
                paymentMethodId = paymentMethod.id
                total = request.amount.dollarsString()
                success = result.success
                lastFour = cardLastFour
                meta = transactionMeta
                type = "charge"
                method = "card"
                source = "Android|CPSDK|NMI"
                customerId = customer.id
                invoiceId = invoice.id
                response = gatewayResponse
            }
        ) {
            onError(it)
        }
    }

    /**
     * Finds a mobile reader driver that is ready to take a payment
     *
     * @param repo A [MobileReaderDriverRepository] to look for the readers in
     * @return a [MobileReaderDriver], if found
     */
    private suspend fun getAvailableMobileReaderDriver(repo: MobileReaderDriverRepository): MobileReaderDriver? = repo
        .getDrivers()
        .firstOrNull { it.isReadyToTakePayment() }

}