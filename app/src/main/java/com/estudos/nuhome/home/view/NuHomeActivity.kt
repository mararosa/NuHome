/*
 * Copyright 2017 Google, Inc.
 *
 * ...
 */

package com.estudos.nuhome.home.view

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.estudos.nuhome.databinding.ActivityNuHomeBinding
import com.estudos.nuhome.home.domain.NuHomeInteractor
import com.estudos.nuhome.home.domain.NuHomeInteractorImpl
import com.estudos.nuhome.home.domain.NuHomeVO
import com.estudos.nuhome.home.domain.mapper.toVO
import com.estudos.nuhome.home.viewmodel.NuHomeViewModel
import com.estudos.nuhome.home.viewmodel.NuHomeViewModelFactory
import com.estudos.nuhome.service.ServiceImpl
import com.estudos.nuhome.service.response.HomeUserDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NuHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNuHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = NuHomeViewModelFactory(interactor = NuHomeInteractorImpl())
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(NuHomeViewModel::class.java)

        binding = ActivityNuHomeBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        setContentView(binding.root)
        setupClickListeners()
        viewModel.loadInfo()
    }


//    private fun setupView(vo: NuHomeVO?) {
//        vo?.let {
//            binding.brandIcon.setImageResource(it.creditCardIcon)
//        }
//        binding.userName.text = vo?.userName
//        binding.balanceAvailableValue.text = vo?.totalAmoutAvailable
//    }

    private fun setupClickListeners() {
        binding.buttonSettings.setOnClickListener {
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }
    }
}