package com.estudos.nuhome.home.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.estudos.nuhome.R
import com.estudos.nuhome.home.domain.NuHomeInteractor
import com.estudos.nuhome.home.domain.NuHomeVO
import com.estudos.nuhome.home.domain.mapper.toVO
import com.estudos.nuhome.service.response.HomeUserDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//qual e a diferenca dessa minha viewmodel pra de base de cards que tem o onCreate?
class NuHomeViewModel(
    private val interactor: NuHomeInteractor
) : ViewModel() {
    var infoVO: NuHomeVO? = NuHomeVO(
        userName = "",
        totalAmoutAvailable = "",
        creditCardIcon = R.drawable.icon_card_unknown
    )

    fun loadInf() {
        val callback = interactor.fetchHomeCards()
        callback.enqueue(object : Callback<HomeUserDetailsResponse> {
            override fun onResponse(
                call: Call<HomeUserDetailsResponse>,
                response: Response<HomeUserDetailsResponse>
            ) {
                infoVO = response.body()?.toVO()
            }

            override fun onFailure(call: Call<HomeUserDetailsResponse>, t: Throwable) {
                Log.ERROR
            }

        })
    }


}