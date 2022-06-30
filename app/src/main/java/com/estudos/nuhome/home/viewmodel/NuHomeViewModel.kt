package com.estudos.nuhome.home.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.estudos.nuhome.R
import com.estudos.nuhome.home.domain.NuHomeInteractor
import com.estudos.nuhome.home.domain.NuHomeVO
import com.estudos.nuhome.home.domain.mapper.toVO
import com.estudos.nuhome.service.response.HomeUserDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NuHomeViewModel(
    private val interactor: NuHomeInteractor
) : ViewModel() {
    var infoVO: NuHomeVO? = NuHomeVO(
        userName = "",
        totalAmoutAvailable = "",
        creditCardIcon = R.drawable.icon_card_unknown
    )

    //Add live data para a tela ouvir a info que chega da request
    fun loadInfo() {
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