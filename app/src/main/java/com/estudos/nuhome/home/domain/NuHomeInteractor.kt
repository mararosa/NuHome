package com.estudos.nuhome.home.domain

import android.content.res.Resources
import com.estudos.nuhome.home.data.model.response.CredicardCardUserDetails
import com.estudos.nuhome.home.domain.mapper.toVO
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

interface NuHomeInteractor {
    fun fetchUserCreditCardInfo(): NuHomeVO?
}

class NuHomeInteractorImpl() : NuHomeInteractor {

    //Preciso usar moshi pq meu "json"eh uma string e ai preciso transformar em objeto
    //retrofit faz por debaixo dos panos
    //moshi.adapter(BaseValidation::class.java) eh meu objeto

    val json: String = "{\n    \"user_name\": \"Mara\",\n    \"credit_card_brand\": \"mastercard\",\n    \"available_balance\": 589200.47\n}"
    val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    @OptIn(ExperimentalStdlibApi::class)
    val jsonAdapter: JsonAdapter<CredicardCardUserDetails> = moshi.adapter<CredicardCardUserDetails>()
    val userDetails = jsonAdapter.fromJson(json)

    override fun fetchUserCreditCardInfo(): NuHomeVO? =
        userDetails?.toVO() //NAo me lembro de alguma vez ter esperado um retorno nullable
}