package com.example.firebaseauth


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class ForgotPasswordActivity : AppCompatActivity() {

    //5. inisilisasi fungsi button
    private lateinit var btnSendEmail: Button
    private lateinit var tbForgotPass: androidx.appcompat.widget.Toolbar

    //8. panggil fungsi button
    private lateinit var etEmailForgotPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        //6.Inisialisasi tombol setelah setContentView
        btnSendEmail = findViewById(R.id.btnSendEmail)
        tbForgotPass = findViewById(R.id.tbForgotPass)

        //8. panggil fungsi button
        etEmailForgotPass = findViewById(R.id.etEmailForgotPass)

        //1. bikin fungsi action bar
        initActionBar()

        //3. panggil fungsi button
        btnSendEmail.setOnClickListener {
            //8. panggil fungsi button
            val email = etEmailForgotPass.text.toString().trim()

            //9. panggil fungsi validasi input
            if (email.isEmpty()){
                etEmailForgotPass.error = "Please field your email"
                etEmailForgotPass.requestFocus()
                return@setOnClickListener
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                etEmailForgotPass.error = "Please use valid email"
                etEmailForgotPass.requestFocus()
                return@setOnClickListener
            }else{
                //10. panggil fungsi forgot password
                forgotPass(email)
            }

//           Toast.makeText(this, "Email sent", Toast.LENGTH_SHORT).show()
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

    //10. panggil fungsi forgot password
    private fun forgotPass(email: String) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Your reset password has been sent to your email", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, SignInActivity::class.java))
                    finishAffinity()
                }else{
                    Toast.makeText(this, "Failed reset password", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
            }
    }
}