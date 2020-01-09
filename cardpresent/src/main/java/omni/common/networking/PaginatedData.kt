package omni.common.networking

import kotlinx.serialization.Serializable
import omni.common.data.models.Transaction

@Serializable
open class PaginatedData<T>(val data: List<T>)

@Serializable
class PaginatedTransactions(val data: List<Transaction>)
