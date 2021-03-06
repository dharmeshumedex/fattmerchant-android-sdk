package com.fattmerchant.android

import com.fattmerchant.android.chipdna.ChipDnaDriver
import com.fattmerchant.omni.data.MobileReader
import com.fattmerchant.omni.data.MobileReaderDriver
import com.fattmerchant.omni.data.models.Transaction
import com.fattmerchant.omni.data.repository.MobileReaderDriverRepository

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
    }

}