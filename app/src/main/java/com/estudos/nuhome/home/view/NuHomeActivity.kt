package com.estudos.nuhome.home.view

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.estudos.nuhome.R
import com.estudos.nuhome.databinding.ActivityNuHomeBinding
import com.estudos.nuhome.home.data.NuHomeRepositoryImpl
import com.estudos.nuhome.home.data.model.response.HomeUserDetailsResponse
import com.estudos.nuhome.home.domain.NuHomeInteractorImpl
import com.estudos.nuhome.home.domain.NuHomeVO
import com.estudos.nuhome.home.domain.mapper.toVO
import com.estudos.nuhome.service.ServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NuHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNuHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        fecthHomeCardDetails()
        setupClickListeners()
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

    private fun fecthHomeCardDetails() {
        val callback = ServiceImpl.createService().fetchHomeCards()
        callback.enqueue(object : Callback<HomeUserDetailsResponse> {
            override fun onResponse(
                call: Call<HomeUserDetailsResponse>,
                response: Response<HomeUserDetailsResponse>
            ) {
                val vo = response.body()?.toVO()
                setupView(vo)
            }

            override fun onFailure(call: Call<HomeUserDetailsResponse>, t: Throwable) {
                Toast.makeText(this@NuHomeActivity, "Error", Toast.LENGTH_SHORT).show()
            }

        })

    }
}