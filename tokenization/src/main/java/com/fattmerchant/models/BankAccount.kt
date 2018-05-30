package com.fattmerchant.models

import com.squareup.moshi.Json

/** A bank account */
class BankAccount (

    @Json(name = "person_name")
    var personName: String,

    @Json(name = "bank_type")
    var bankType: String = "checkings",

    @Json(name = "bank_holder_type")
    var bankHolderType: String = "business",

    @Json(name = "bank_account")
    var bankAccount: String,

    @Json(name = "bank_routing")
    var bankRouting: String,

    @Json(name = "address_zip")
    var addressZip: String,

    @Json(name = "bank_name")
    var bankName: String? = null,

    @Json(name = "address_1")
    var address1: String? = null,

    @Json(name = "address_2")
    var address2: String? = null,

    @Json(name = "address_city")
    var addressCity: String? = null,

    @Json(name = "address_state")
    var addressState: String? = null,

    @Json(name = "customer_id")
    var customerId: String? = null,

    var note: String? = null,
    var phone: String? = null,
    var email: String? = null,
    private var method: String = "bank"
) {

    companion object {

        /**
         * Creates a test bank account
         *
         * @return a test bank account
         */
        fun testBankAccount(): BankAccount {
            val bankAccount = BankAccount(personName = "Jim Parsnip", bankType = "savings", bankAccount = "9876543210", bankRouting = "021000021", addressZip = "32822")
            bankAccount.address1 = "123 Orange Ave"
            bankAccount.address2 = "Unit 309"
            bankAccount.addressCity = "Orlando"
            bankAccount.addressState = "FL"
            bankAccount.phone = "3210000000"
            bankAccount.email = "fatt@merchant.com"
            bankAccount.note = "This is a test credit card"

            return bankAccount
        }

        /**
         * Creates a test bank account that fails processing
         *
         * @return a test bank account
         */
        fun failingTestBankAccount(): BankAccount {
            val bankAccount = BankAccount(personName = "Jim Parsnip", bankAccount = "9876543210", bankRouting = "021000021", addressZip = "32822")

            bankAccount.address1 = "123 Orange Ave"
            bankAccount.address2 = "Unit 309"
            bankAccount.addressCity = "Orlando"
            bankAccount.addressState = "FL"
            bankAccount.phone = "3210000000"
            bankAccount.email = "fatt@merchant.com"
            bankAccount.note = "This is a test credit card"

            return bankAccount
        }
    }

}
