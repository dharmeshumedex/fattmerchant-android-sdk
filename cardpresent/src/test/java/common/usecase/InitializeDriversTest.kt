package common.usecase

//import omni.Omni
//import android.api.OmniApi
//import android.api.OmniService
//import omni.networking.PaginatedData
//import android.customer.Customer
//import android.invoice.Invoice
//import android.payment_method.PaymentMethod
//import android.transaction.Transaction
import common.data.*
import omni.common.data.models.Transaction
import kotlinx.coroutines.*
import omni.common.data.MobileReader
import omni.common.data.MobileReaderDriver
import omni.common.data.repository.MobileReaderDriverRepository


class InitializeDriversTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private val scope = GlobalScope

    val mockMobileReaderDriverRepository = object: MobileReaderDriverRepository {

        override suspend fun getDriverFor(transaction: Transaction): MobileReaderDriver? {
            return null
        }

        override suspend fun getDriverFor(mobileReader: MobileReader): MobileReaderDriver? {
            return null
        }

        override suspend fun getDrivers(): List<MobileReaderDriver> {
            return listOf()
        }
    }


}