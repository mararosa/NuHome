/*
 * Copyright 2017 Google, Inc.
 *
 * ...
 */

package com.estudos.nuhome.home.view

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.estudos.nuhome.databinding.ActivityNuHomeBinding
import com.estudos.nuhome.home.domain.NuHomeInteractorImpl
import com.estudos.nuhome.home.domain.NuHomeVO
import com.estudos.nuhome.home.viewmodel.NuHomeViewModel
import com.estudos.nuhome.home.viewmodel.NuHomeViewModelFactory

class NuHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNuHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = NuHomeViewModelFactory(interactor = NuHomeInteractorImpl())
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(NuHomeViewModel::class.java)

        /** Setting up LiveData observation relationship **/
        viewModel.infoVO.observe(this, Observer { setupView(it) })

        binding = ActivityNuHomeBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        setContentView(binding.root)
        setupClickListeners()
        viewModel.loadInfo()
    }


    private fun setupView(vo: NuHomeVO?) {
        vo?.let {
            binding.brandIcon.setImageResource(it.creditCardIcon)
        }
        binding.userName.text = vo?.userName
        binding.balanceAvailableValue.text = vo?.totalAmoutAvailable
    }

    private fun setupClickListeners() {
        binding.buttonSettings.setOnClickListener {
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }
    }
}