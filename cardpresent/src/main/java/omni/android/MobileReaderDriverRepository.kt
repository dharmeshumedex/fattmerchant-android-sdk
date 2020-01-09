package omni.android

import omni.android.chipdna.ChipDnaDriver
import omni.common.data.MobileReader
import omni.common.data.MobileReaderDriver
import omni.common.data.models.Transaction
import omni.common.data.repository.MobileReaderDriverRepository

class MobileReaderDriverRepository : MobileReaderDriverRepository {

    private var chipDna = ChipDnaDriver()

    override suspend fun getDrivers(): List<MobileReaderDriver> {
        return listOf(chipDna)
    }

    override suspend fun getDriverFor(transaction: Transaction): MobileReaderDriver? {
        if (transaction.source?.contains("CPSDK") == true) {
            return chipDna
        }
        return null
    }

    override suspend fun getDriverFor(mobileReader: MobileReader): MobileReaderDriver? {
        return chipDna
//        return if (mobileReader.getName().contains("Miura") || ) {
//            chipDna
//        } else {
//            null
//        }
    }

}