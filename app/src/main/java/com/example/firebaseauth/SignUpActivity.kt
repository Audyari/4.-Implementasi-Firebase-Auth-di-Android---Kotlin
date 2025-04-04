package com.example.firebaseauth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        //1. bikin fungsi action bar
        initActionBar()

    }

    //2. panggik fungsi action bar di onCreate agar muncul tbSignUp
    private fun initActionBar() {
        setSupportActionBar(findViewById(R.id.tbSignUp))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }
}