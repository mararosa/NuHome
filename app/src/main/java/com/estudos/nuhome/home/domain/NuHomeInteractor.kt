package com.estudos.nuhome.home.domain

import com.estudos.nuhome.home.data.NuHomeRepository
import com.estudos.nuhome.home.data.NuHomeRepositoryImpl
import com.estudos.nuhome.service.response.HomeUserDetailsResponse
import retrofit2.Call

interface NuHomeInteractor {
    fun fetchHomeCards(): Call<HomeUserDetailsResponse>
}

class NuHomeInteractorImpl(
    val repository: NuHomeRepository = NuHomeRepositoryImpl()
) : NuHomeInteractor {
    override fun fetchHomeCards(): Call<HomeUserDetailsResponse> =
        repository.fetchHomeCards()
}