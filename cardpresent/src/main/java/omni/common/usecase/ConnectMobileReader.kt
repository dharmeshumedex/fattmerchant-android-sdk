package omni.common.usecase

import omni.common.data.MobileReader
import omni.common.data.models.OmniException
import omni.common.data.repository.MobileReaderDriverRepository
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

/**
 * Connects a single mobile reader from the [mobileReaderDriverRepository]
 */
class ConnectMobileReader(
        override val coroutineContext: CoroutineContext,
        var mobileReaderDriverRepository: MobileReaderDriverRepository,
        var mobileReader: MobileReader
) : CoroutineScope {

    suspend fun start(): Boolean {
        return try {
            mobileReaderDriverRepository
                .getDriverFor(mobileReader)
                ?.connectReader(mobileReader)
                ?: false
        } catch (e: OmniException) {
            false
        }
    }
}