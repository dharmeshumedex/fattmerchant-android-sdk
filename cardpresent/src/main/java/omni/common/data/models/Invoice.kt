package omni.common.data.models

import kotlinx.serialization.*
import kotlinx.serialization.json.JsonObject

/**
 * An Omni invoice
 *
 */
@Serializable
open class Invoice : Model {
    override var id: String? = null

    @SerialName("balance_due")
    open var balanceDue: String? = null

    @SerialName("created_at")
    open var createdAt: String? = null

    @SerialName("customer_id")
    open var customerId: String? = null

    @SerialName("deleted_at")
    open var deletedAt: String? = null

    @SerialName("due_at")
    open var dueAt: String? = null

    @SerialName("is_merchant_present")
    open var isMerchantPresent: Boolean? = null

    @SerialName("is_webpayment")
    open var isWebpayment: Boolean? = null

    @SerialName("merchant_id")
    open var merchantId: String? = null

    open var meta: JsonObject? = null

    @SerialName("paid_at")
    open var paidAt: String? = null

    @SerialName("payment_attempt_failed")
    open var paymentAttemptFailed: Boolean? = null

    @SerialName("payment_attempt_message")
    open var paymentAttemptMessage: String? = null

    @SerialName("payment_method_id")
    open var paymentMethodId: String? = null

    @SerialName("schedule_id")
    open var scheduleId: String? = null

    @SerialName("sent_at")
    open var sentAt: String? = null

    open var status: String? = null
    open var total: String? = null

    @SerialName("total_paid")
    open var totalPaid: String? = null

    @SerialName("updated_at")
    open var updatedAt: String? = null

    open var url: String? = null

    @SerialName("user_id")
    open var userId: String? = null

    @SerialName("viewed_at")
    open var viewedAt: String? = null
}