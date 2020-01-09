package omni.common.usecase

import kotlinx.coroutines.*
import omni.common.data.models.OmniException
import omni.common.data.repository.MobileReaderDriverRepository
import kotlin.coroutines.CoroutineContext

/**
 * Initializes all the drivers provided by the mobileReaderDriverRepository
 */
class InitializeDrivers(
        private val mobileReaderDriverRepository: MobileReaderDriverRepository,
        private val args: Map<String, Any>,
        override val coroutineContext: CoroutineContext
) : CoroutineScope {

    class InitializeDriversException(message: String? = null) : OmniException("Could not initialize drivers", message)

    suspend fun start(error: (OmniException) -> Unit) {

        val handler = CoroutineExceptionHandler { _, exception ->
            error(InitializeDriversException(exception.message))
        }

//        GlobalScope.launch(handler) {
            mobileReaderDriverRepository
                    .getDrivers()
                    .forEach {
                        it.initialize(args)
                    }
//        }

    }
}