package omni.common.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class Customer : Model {
    override var id: String? = null

    @SerialName("address_1")
    open var address1: String? = null

    @SerialName("address_2")
    open var address2: String? = null

    @SerialName("address_city")
    open var addressCity: String? = null

    @SerialName("address_country")
    open var addressCountry: String? = null

    @SerialName("address_state")
    open var addressState: String? = null

    @SerialName("address_zip")
    open var addressZip: String? = null

    @SerialName("allow_invoice_credit_card_payments")
    open var allowInvoiceCreditCardPayments: Boolean? = null

    @SerialName("cc_emails")
    open var ccEmails: String? = null

    @SerialName("cc_sms")
    open var ccSms: String? = null

    open var company: String? = null

    @SerialName("created_at")
    open var createdAt: String? = null

    @SerialName("deleted_at")
    open var deletedAt: String? = null

    open var email: String? = null
    open var firstname: String? = null
    open var lastname: String? = null

    @SerialName("merchant_id")
    open var merchantId: String? = null

    open var notes: String? = null
    open var phone: String? = null
    open var reference: String? = null

    @SerialName("updated_at")
    open var updatedAt: String? = null
}