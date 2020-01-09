package omni.common.data.repository

import omni.common.data.models.OmniException
import omni.common.data.models.Transaction

interface TransactionRepository : ModelRepository<Transaction> {

    class CreateTransactionException(message: String? = null) : OmniException("Could not create transaction", message)
    class GetTransactionException(message: String? = null) : OmniException("Could not get transactions", message)

    override suspend fun create(model: Transaction, error: (OmniException) -> Unit): Transaction? =
        omniApi.createTransaction(model) {
            error(CreateTransactionException(it.message))
        }

    override suspend fun get(error: (OmniException) -> Unit): List<Transaction>? = omniApi.getTransactions {
        error(GetTransactionException(it.message))
    }

}