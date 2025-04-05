package com.example.firebaseauth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //1. panggil fungsi splash screen

       CoroutineScope(Dispatchers.Main).launch {

           //2. Mengganti aktivitas setelah 1200 ms (1,2 detik)
           delay(1200)  // Menunggu 1200 ms

           //4. panggil fungsi check auth
           checkAuth()
           finish()  // Opsional, jika ingin menutup aktivitas ini
       }

    }
    //4. panggil fungsi check auth
    private fun checkAuth() {
        if (FirebaseAuth.getInstance().currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
    }
}

