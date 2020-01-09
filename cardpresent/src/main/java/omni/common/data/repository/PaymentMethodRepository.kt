package omni.common.data.repository

import omni.common.data.models.OmniException
import omni.common.data.models.PaymentMethod

interface PaymentMethodRepository : ModelRepository<PaymentMethod> {

    class CreatePaymentMethodException(message: String? = null) :
        OmniException("Could not create payment method", message)

    override suspend fun create(model: PaymentMethod, error: (OmniException) -> Unit): PaymentMethod? {
        return omniApi.createPaymentMethod(model) {
            error(CreatePaymentMethodException(it.message))
        }
    }
}