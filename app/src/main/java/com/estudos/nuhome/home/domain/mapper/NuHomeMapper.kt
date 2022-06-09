package com.estudos.nuhome.home.domain.mapper

import com.estudos.nuhome.R
import com.estudos.nuhome.home.data.model.response.CredicardCardUserDetails
import com.estudos.nuhome.home.domain.CreditCardBrand
import com.estudos.nuhome.home.domain.NuHomeVO
import extension.formatForBrazilianCurrency

fun CredicardCardUserDetails.toVO() =
    NuHomeVO(
        userName = this.name.orEmpty(),
        totalAmoutAvailable = this.availableBalance.formatForBrazilianCurrency(),
        creditCardIcon = CreditCardBrand.getEnumValue(this.creditCardType.orEmpty())
            .toSetBrandIcon(),
    )

fun CreditCardBrand.toSetBrandIcon() =
    when (this) {
        CreditCardBrand.MASTERCARD -> R.drawable.icon_card_mastercard
        CreditCardBrand.VISA -> R.drawable.icon_card_visa
        CreditCardBrand.ELO -> R.drawable.icon_card_elo
        CreditCardBrand.HIPERCARD -> R.drawable.icon_card_hipercard
        CreditCardBrand.AMERICAN_EXPRESS -> R.drawable.icon_card_americanexpress
        else -> R.drawable.icon_card_unknown
    }



