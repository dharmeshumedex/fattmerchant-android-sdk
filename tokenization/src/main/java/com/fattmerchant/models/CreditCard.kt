package com.fattmerchant.models

import com.squareup.moshi.Json

/** A credit card */
class CreditCard (

    @Json(name = "person_name")
    var personName: String,

    @Json(name = "card_number")
    var cardNumber: String,

    @Json(name = "card_exp")
    var cardExp: String,

    @Json(name = "address_zip")
    var addressZip: String,

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
    private var method: String = "card"
) {

    companion object {

        /**
         * Creates a test credit card
         *
         * @return a test credit card
         */
        fun testCreditCard(): CreditCard {
            val creditCard = CreditCard(personName = "Joan Parsnip", cardNumber = "4111111111111111", cardExp = "1230", addressZip = "32822")
            creditCard.address1 = "123 Orange Ave"
            creditCard.address2 = "Unit 309"
            creditCard.addressCity = "Orlando"
            creditCard.addressState = "FL"
            creditCard.phone = "3210000000"
            creditCard.email = "fatt@merchant.com"
            creditCard.note = "This is a test credit card"

            return creditCard
        }

        /**
         * Creates a test credit card that fails processing
         *
         * @return a test credit card
         */
        fun failingTestCreditCard(): CreditCard {
            val creditCard = CreditCard(personName = "Joan Parsnip", cardNumber = "4111111111111111", cardExp = "", addressZip = "32822")
            creditCard.address1 = "123 Orange Ave"
            creditCard.address2 = "Unit 309"
            creditCard.addressCity = "Orlando"
            creditCard.addressState = "FL"
            creditCard.phone = "3210000000"
            creditCard.email = "fatt@merchant.com"
            creditCard.note = "This is a test credit card"

            return creditCard
        }
    }

}
