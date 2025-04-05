package com.example.firebaseauth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class SignUpActivity : AppCompatActivity() {

    //4. inisilisasi fungsi button
    private lateinit var btnSignUp: Button
    private lateinit var tbSignUp: androidx.appcompat.widget.Toolbar

    //6. inisilisasi fungsi edit text
    private lateinit var etEmailSignUp: EditText
    private lateinit var etPasswordSignUp: EditText
    private lateinit var etConfirmPasswordSignUp: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        // 5.Inisialisasi tombol dan toolbar setelah setContentView
        btnSignUp = findViewById(R.id.btnSignUp)
        tbSignUp = findViewById(R.id.tbSignUp)

        //6. inisialisai lagi email, password confirm password

        etEmailSignUp = findViewById(R.id.etEmailSignUp)
        etPasswordSignUp = findViewById(R.id.etPasswordSignUp)
        etConfirmPasswordSignUp = findViewById(R.id.etConfirmPasswordSignUp)



        //1. bikin fungsi action bar
        initActionBar()

        //3. panggil fungsi button
        btnSignUp.setOnClickListener {

            //6. panggil fungsi edit text
            val email = etEmailSignUp.text.toString().trim()
            val pass = etPasswordSignUp.text.toString().trim()
            val confirmPass = etConfirmPasswordSignUp.text.toString().trim()

            //9. panggil fungsi loading
            CustomDialog.showLoading(this)

            //7. panggil fungsi Validasi input
            if (!isValidInput(email, pass, confirmPass)) return@setOnClickListener

            //8. panggil fungsi register ke firebase
            // Registrasi ke server
            registerToServer(email, pass)


//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
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

    //7. panggil fungsi validasi input
    private fun isValidInput(email: String, pass: String, confirmPass: String): Boolean {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailSignUp.error = "Invalid Email Format"
            return false
        }

        if (pass.length < 6) {
            etPasswordSignUp.error = "Password must be at least 6 characters"
            return false
        }

        if (pass != confirmPass) {
            etConfirmPasswordSignUp.error = "Passwords do not match"
            return false
        }
        //9. panggil fungsi loading
        CustomDialog.showLoading(this)


        return true
    }

    //8. panggil fungsi register ke firebase
    private fun registerToServer(email: String, pass: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->

                //9. panggil fungsi loading
                CustomDialog.showLoading(this)

                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                } else {
                    Toast.makeText(this, "Registration failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                //9. panggil fungsi loading
                CustomDialog.showLoading(this)

                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
    }


}