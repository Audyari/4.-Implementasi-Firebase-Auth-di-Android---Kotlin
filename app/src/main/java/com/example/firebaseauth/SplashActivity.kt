package com.example.firebaseauth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //1. panggil fungsi splash screen

       CoroutineScope(Dispatchers.Main).launch {
           delay(1200)  // Menunggu 1200 ms
           startActivity(Intent(this@SplashActivity, AuthActivity::class.java))
           finish()  // Opsional, jika ingin menutup aktivitas ini
       }

        //2. cara lama pake handler depracated

        // Handler().postDelayed({
        //     startActivity(Intent(this, AuthActivity::class.java))
        //     finish()
        // }, 1200)

    }
}

