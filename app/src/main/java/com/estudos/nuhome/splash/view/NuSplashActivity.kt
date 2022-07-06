package com.estudos.nuhome.splash.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estudos.nuhome.home.view.NuHomeActivity

class NuSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, NuHomeActivity::class.java))
        finish()
    }
}