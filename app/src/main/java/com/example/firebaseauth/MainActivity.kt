package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogout = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}