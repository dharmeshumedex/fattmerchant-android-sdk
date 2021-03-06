package com.fattmerchant.omni.data.repository

import com.fattmerchant.omni.data.MobileReader
import com.fattmerchant.omni.data.MobileReaderDriver
import com.fattmerchant.omni.data.models.Transaction

interface MobileReaderDriverRepository {

    /**
     * Returns the available [MobileReaderDriver]s
     *
     * @return The list of available [MobileReaderDriver]s
     */
    suspend fun getDrivers(): List<MobileReaderDriver>

    /**
     * Returns the driver that knows how to handle the given transaction
     *
     * @return MobileReaderDriver The driver for this kind of transaction or null if not found
     * */
    suspend fun getDriverFor(transaction: Transaction): MobileReaderDriver?

    /**
     * Returns the driver that knows how to communicate with the given mobile reader
     *
     * @param mobileReader
     * @return
     */
    suspend fun getDriverFor(mobileReader: MobileReader): MobileReaderDriver?
}