package com.estudos.nuhome.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class CurrencyUtil {
    companion object {
        fun Double?.formatForBrazilianCurrency(): String {
            val brazilianFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
            return brazilianFormat.format(this)
        }

        fun formatForBrazilianCurrency2(value: Double?): String {
            val brazilianFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
            return brazilianFormat.format(value)
        } //Qual eh o problema das classes utilitarias?

    }
}