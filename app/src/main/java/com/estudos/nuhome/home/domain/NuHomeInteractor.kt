package com.estudos.nuhome.home.domain

import com.estudos.nuhome.home.data.NuHomeRepository
import com.estudos.nuhome.home.data.NuHomeRepositoryImpl
import com.estudos.nuhome.home.data.model.response.HomeUserDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NuHomeInteractor {
}

class NuHomeInteractorImpl(val repository: NuHomeRepository = NuHomeRepositoryImpl()) :
    NuHomeInteractor {


}