package com.example.firebaseauth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity

//1.extend ke ComponentActivity()
class AuthActivity : ComponentActivity() {

    //1. Deklarasi button
    private lateinit var btnSignInAuth: Button
    private lateinit var btnSignUpAuth: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //2. Inisialisasi button
        btnSignInAuth = findViewById(R.id.btnSignInAuth)
        btnSignUpAuth = findViewById(R.id.btnSignUpAuth)

        //3. Listener untuk button Sign In
        btnSignInAuth.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@AuthActivity, SignInActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            }
        })

        //4. Listener untuk button Sign Up
        btnSignUpAuth.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@AuthActivity, SignUpActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            }
        })
    }
}