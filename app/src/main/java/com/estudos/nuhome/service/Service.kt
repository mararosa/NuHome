package com.estudos.nuhome.service

import com.estudos.nuhome.service.response.HomeUserDetailsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface Service {

    @GET("/nu/home")
    fun fetchHomeCards(): Call<HomeUserDetailsResponse>
}

class ServiceImpl {
    companion object {
        private val BASE_URL = "https://edimara.free.beeceptor.com"
        private val clientBuilder = OkHttpClient.Builder()

        fun createService(): Service {
            val moshi =
                Moshi
                    .Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(Service::class.java)
        }
    }
}