package omni.common.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * An Omni Payment Method
 *
 */
@Serializable
open class PaymentMethod : Model {

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

    @SerialName("bank_holder_type")
    open var bankHolderType: String? = null

    @SerialName("bank_name")
    open var bankName: String? = null

    @SerialName("bank_type")
    open var bankType: String? = null

    @SerialName("card_exp")
    open var cardExp: String? = null

    @SerialName("card_last_four")
    open var cardLastFour: String? = null

    @SerialName("card_type")
    open var cardType: String? = null

    @SerialName("created_at")
    open var createdAt: String? = null

    @SerialName("customer_id")
    open var customerId: String? = null

    @SerialName("deleted_at")
    open var deletedAt: String? = null

    @SerialName("has_cvv")
    open var hasCvv: Boolean? = null

    @SerialName("merchant_id")
    open var merchantId: String? = null

    open var meta: String? = null
    open var method: String? = null
    open var nickname: String? = null

    @SerialName("person_name")
    open var personName: String? = null

    open var tokenize: Boolean? = null

    @SerialName("updated_at")
    open var updatedAt: String? = null
}