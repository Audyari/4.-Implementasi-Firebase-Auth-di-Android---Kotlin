package com.example.firebaseauth


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class ForgotPasswordActivity : AppCompatActivity() {

    //5. inisilisasi fungsi button
    private lateinit var btnSendEmail: Button
    private lateinit var tbForgotPass: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        //6.Inisialisasi tombol setelah setContentView
        btnSendEmail = findViewById(R.id.btnSendEmail)
        tbForgotPass = findViewById(R.id.tbForgotPass)

        //1. bikin fungsi action bar
        initActionBar()

        //3. panggil fungsi button
        btnSendEmail.setOnClickListener {
           Toast.makeText(this, "Email sent", Toast.LENGTH_SHORT).show()
        }

        //7. panggil fungsi toolbar signup
        tbForgotPass.setNavigationOnClickListener {
            finish()
        }
    }

    //2. panggik fungsi action bar di onCreate agar muncul tbSignUp
    private fun initActionBar() {
        setSupportActionBar(findViewById(R.id.tbForgotPass))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }
}