package com.estudos.nuhome.home.domain

import androidx.annotation.DrawableRes

data class NuHomeVO(
    val userName: String,
    val totalAmoutAvailable: String,
    @DrawableRes val creditCardIcon: Int
)
