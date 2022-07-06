package com.estudos.nuhome.home.data

import com.estudos.nuhome.service.response.HomeUserDetailsResponse
import com.estudos.nuhome.service.Service
import com.estudos.nuhome.service.ServiceImpl
import retrofit2.Call

interface NuHomeRepository {
    fun fetchHomeCards(): Call<HomeUserDetailsResponse>
}

class NuHomeRepositoryImpl(val service: Service = ServiceImpl.createService()) : NuHomeRepository {

    override fun fetchHomeCards(): Call<HomeUserDetailsResponse> =
        service.fetchHomeCards()
}