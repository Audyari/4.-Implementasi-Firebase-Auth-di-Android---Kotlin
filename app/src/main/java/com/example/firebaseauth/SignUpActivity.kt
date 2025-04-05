package com.example.firebaseauth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity


class SignUpActivity : AppCompatActivity() {

    //4. inisilisasi fungsi button
    private lateinit var btnSignUp: Button
    private lateinit var tbSignUp: androidx.appcompat.widget.Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        // 5.Inisialisasi tombol dan toolbar setelah setContentView
        btnSignUp = findViewById(R.id.btnSignUp)
        tbSignUp = findViewById(R.id.tbSignUp)

        //1. bikin fungsi action bar
        initActionBar()

        //3. panggil fungsi button
        btnSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        //5. panggil fungsi toolbar signup
        tbSignUp.setNavigationOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }


    }

    //2. panggik fungsi action bar di onCreate agar muncul tbSignUp
    private fun initActionBar() {
        setSupportActionBar(findViewById(R.id.tbSignUp))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }
}