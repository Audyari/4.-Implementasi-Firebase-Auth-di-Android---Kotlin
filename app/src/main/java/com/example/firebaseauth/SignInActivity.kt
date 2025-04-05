package com.example.firebaseauth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignInActivity : AppCompatActivity() {

    //1 Declare views
    private lateinit var btnSignIn: Button
    private lateinit var tvForgotPass: TextView
    private lateinit var tbSignIn: androidx.appcompat.widget.Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //2. Initialize views after setting content view
        btnSignIn = findViewById(R.id.btnSignIn)
        tvForgotPass = findViewById(R.id.tv_ForgotPass)
        tbSignIn = findViewById(R.id.tbSignIn)

        //3. Initialize action bar

        initActionBar()

        //4. Set button click listeners
        btnSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
        }

        //4. Set button click listeners
        tvForgotPass.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        //5. Set toolbar navigation click listener
        tbSignIn.setNavigationOnClickListener {
            // Handle toolbar navigation click
            //finish()
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }

    //3. Initialize action bar
    private fun initActionBar() {
        setSupportActionBar(findViewById(R.id.tbSignIn))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = ""
        }
    }
}