package omni.common.usecase

import omni.common.data.MobileReader
import omni.common.data.repository.MobileReaderDriverRepository
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

/**
 * Searches for all readers in the mobileReaderDriverRepository
 */
class SearchForReaders(
        private val mobileReaderDriverRepository: MobileReaderDriverRepository,
        private val args: Map<String, Any>,
        override val coroutineContext: CoroutineContext
) : CoroutineScope {

    suspend fun start(): List<MobileReader> = mobileReaderDriverRepository
        .getDrivers()
        .flatMap { it.searchForReaders(args) }

}