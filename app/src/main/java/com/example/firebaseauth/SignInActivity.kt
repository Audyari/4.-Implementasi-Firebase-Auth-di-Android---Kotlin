package com.example.firebaseauth


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_in)

        //1. Menambahkan edge to edge support
        initActionBar()

    }

    //2. Menambahkan support action bar
    private fun initActionBar() {
        setSupportActionBar(findViewById(R.id.tbSignIn))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }
}