package com.estudos.nuhome.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estudos.nuhome.R
import com.estudos.nuhome.databinding.ActivityNuHomeBinding
import com.estudos.nuhome.home.domain.NuHomeInteractorImpl

class NuHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNuHomeBinding
    private var interactor = NuHomeInteractorImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupView()
    }


    private fun setupView() {
        val values = interactor.fetchUserCreditCardInfo()
        values?.let { binding.brandIcon.setImageResource(it.creditCardIcon) }
        binding.userName.text = values?.userName
        binding.balanceAvailableValue.text = values?.totalAmoutAvailable
    }
}