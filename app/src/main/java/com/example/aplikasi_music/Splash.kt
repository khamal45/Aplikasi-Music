package com.example.aplikasi_music

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            val intent = Intent(this@Splash, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}