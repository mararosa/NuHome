package com.estudos.nuhome.home.data.model.response

import com.squareup.moshi.Json

data class HomeUserDetailsResponse(
    @Json(name = "user_name") val name: String? = null,
    @Json(name = "credit_card_brand") val creditCardType: String? = null,
    @Json(name = "available_balance") val availableBalance: Double? = null
)
