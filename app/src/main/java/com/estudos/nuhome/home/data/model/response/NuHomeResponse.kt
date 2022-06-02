package com.estudos.nuhome.home.data.model.response

import com.squareup.moshi.Json

data class NuHomeResponse(
    @Json(name = "userName") val name: String? = null,
    @Json(name = "creditCardBrand") val creditCardBrand: String? = null,
    @Json(name = "availableBalance") val availableBalance: String? = null
)
