package com.estudos.nuhome.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.estudos.nuhome.home.domain.NuHomeInteractor

class NuHomeViewModelFactory(val interactor: NuHomeInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            NuHomeInteractor::class.java
        )
            .newInstance(interactor)
    }
}