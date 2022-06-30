package com.estudos.nuhome.home.data.model

enum class CreditCardBrand(val type: String? = null) {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    ELO("Elo"),
    AMERICAN_EXPRESS("AmericanExpress"),
    HIPERCARD("Hipercard"),
    UNKNOWN;

    companion object {
        fun getEnumValue(brand: String) =
            values().find { it.type?.equals(brand, ignoreCase = true) == true } ?: UNKNOWN
    }
}