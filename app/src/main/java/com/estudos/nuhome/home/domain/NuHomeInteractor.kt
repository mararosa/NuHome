package com.estudos.nuhome.home.domain

import android.content.res.Resources
import com.estudos.nuhome.R

interface NuHomeInteractor {
    fun fetchUserCreditCardInfo(): NuHomeVO
}

class NuHomeInteractorImpl(val resources: Resources) : NuHomeInteractor {

    val json =
        "{\n    \"user_name\": \"The Rock\",\n    \"credit_card_brand\": \"visa\",\n    \"available_balance\": \"589.052,54\"\n}"

    override fun fetchUserCreditCardInfo(): NuHomeVO {
//        return json.toVO(resources)
        return NuHomeVO("Mara", CreditCardBrand.ELO, "100.052,25", R.drawable.icon_card_elo)
    }
}