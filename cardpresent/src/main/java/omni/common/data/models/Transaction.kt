package omni.common.data.models

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.content

/**
 * An Omni Transaction
 *
 */
@Serializable
open class Transaction : Model {
    override var id: String? = null

    @SerialName("auth_id")
    open var authId: String? = null

    @SerialName("created_at")
    open var createdAt: String? = null

    @SerialName("customer_id")
    open var customerId: String? = null

    open var gateway: String? = null

    @SerialName("gateway_id")
    open var gatewayId: String? = null

    @SerialName("gateway_name")
    open var gatewayName: String? = null

    @SerialName("invoice_id")
    open var invoiceId: String? = null

    @SerialName("is_captured")
    open var isCaptured: Int? = null

    @SerialName("is_manual")
    open var isManual: Boolean? = null

    @SerialName("is_merchant_present")
    open var isMerchantPresent: Boolean? = null

    @SerialName("is_refundable")
    open var isRefundable: Boolean? = null

    @SerialName("issuer_auth_code")
    open var issuerAuthCode: String? = null

    @SerialName("is_voidable")
    open var isVoidable: Boolean? = null

    @SerialName("is_voided")
    open var isVoided: Boolean? = null

    @SerialName("last_four")
    open var lastFour: String? = null

    @SerialName("merchant_id")
    open var merchantId: String? = null

    open var message: String? = null

    @Polymorphic open var meta: JsonObject? = null

    open var method: String? = null

    @SerialName("parent_auth")
    open var parentAuth: String? = null

    @SerialName("payment_method_id")
    open var paymentMethodId: String? = null

    @SerialName("pre_auth")
    open var preAuth: Boolean? = null

    @SerialName("receipt_email_at")
    open var receiptEmailAt: String? = null

    @SerialName("receipt_sms_at")
    open var receiptSmsAt: String? = null

    @SerialName("reference_id")
    open var referenceId: String? = null

    @SerialName("schedule_id")
    open var scheduleId: String? = null

    @SerialName("settled_at")
    open var settledAt: String? = null

    open var source: String? = null

    @SerialName("source_ip")
    open var sourceIp: String? = null

    open var response: JsonObject? = null

    @SerialName("spreedly_token")
    open var spreedlyToken: String? = null

    open var success: Boolean? = null

    open var total: String? = null

    @SerialName("total_refunded")
    open var totalRefunded: String? = null

    open var type: String? = null

    @SerialName("updated_at")
    open var updatedAt: String? = null

    @SerialName("user_id")
    open var userId: String? = null

    fun getMetaString(key: String): String? {
        return try {
            meta?.get(key)?.content
        } catch(e: Exception) {
            null
        }
    }
}