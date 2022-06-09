package com.estudos.nuhome.home.domain.mapper

import android.content.res.Resources
import com.estudos.nuhome.R
import com.estudos.nuhome.home.data.model.response.CredicardCardUserDetails
import com.estudos.nuhome.home.domain.CreditCardBrand
import com.estudos.nuhome.home.domain.NuHomeVO

fun CredicardCardUserDetails.toVO(resources: Resources) =
    NuHomeVO(
        userName = this.name.orEmpty(),
        totalAmoutAvailable = resources.getString(
            R.string.nu_home_amount_available,
            this.availableBalance
        ), //pq aqui nao relcamou do nullo
        creditCardBrand = CreditCardBrand.getEnumValue(this.creditCardType.orEmpty()),
        creditCardIcon = setBrandIcon(this.creditCardType.orEmpty())
    )

fun setBrandIcon(creditCardBrand: String): Int { //QUERIA TER COLOCADO O ENUM :/ MAS FAZ DIFERENCA?
    return when (creditCardBrand) {
        "Mastercard" -> R.drawable.icon_card_mastercard
        "Visa" -> R.drawable.icon_card_visa
        "Elo" -> R.drawable.icon_card_elo
        "Hipercard" -> R.drawable.icon_card_hipercard
        "AmericanExpress" -> R.drawable.icon_card_americanexpress
        else -> R.drawable.icon_card_unknown
    }
}



