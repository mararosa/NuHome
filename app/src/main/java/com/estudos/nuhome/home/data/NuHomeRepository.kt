package com.estudos.nuhome.home.data

import com.estudos.nuhome.home.data.model.response.HomeUserDetailsResponse
import com.estudos.nuhome.service.Service
import com.estudos.nuhome.service.ServiceImpl
import io.reactivex.Single
import retrofit2.Call

interface NuHomeRepository {
    fun fetchHomeCards(): Call<HomeUserDetailsResponse>
}

class NuHomeRepositoryImpl(val service: Service = ServiceImpl.createService()) : NuHomeRepository {

    override fun fetchHomeCards(): Call<HomeUserDetailsResponse> =
        service.fetchHomeCards()
}