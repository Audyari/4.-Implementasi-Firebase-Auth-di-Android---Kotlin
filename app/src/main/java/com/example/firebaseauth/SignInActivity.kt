package com.example.firebaseauth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.*






class SignInActivity : AppCompatActivity() {

    //1 Declare views
    private lateinit var btnSignIn: Button
    private lateinit var tvForgotPass: TextView
    private lateinit var tbSignIn: androidx.appcompat.widget.Toolbar

    //7. Initialize Firebase Authentication
    private lateinit var auth: FirebaseAuth

    //6. Initialize edit text
    private lateinit var etEmailSignIn: TextInputEditText
    private lateinit var etPasswordSignIn: TextInputEditText

//    private lateinit var mGoogleSignInClient: GoogleSignInClient
//    private lateinit var callBackManager: CallbackManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //2. Initialize views after setting content view
        btnSignIn = findViewById(R.id.btnSignIn)
        tvForgotPass = findViewById(R.id.tv_ForgotPass)
        tbSignIn = findViewById(R.id.tbSignIn)

        //6. Initialize edit text
        etEmailSignIn = findViewById(R.id.etEmailSignIn)
        etPasswordSignIn = findViewById(R.id.etPasswordSignIn)


        //3. Initialize action bar

        initActionBar()

        //8. Initialize Firebase Authentication
        initFirebaseAuth()

        //4. Set button click listeners
        btnSignIn.setOnClickListener {

            val email = etEmailSignIn.text.toString().trim()
            val pass = etPasswordSignIn.text.toString().trim()

            //7. panggil fungsi Validasi input
            if (!isValidInput(email, pass)) return@setOnClickListener

            //8. Panggil fungsi login ke firebase
            loginToServer(email, pass)

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

    //9. Initialize Firebase Authentication
    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()

        // Configure Google Sign In
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//
//        callBackManager = CallbackManager.Factory.create()
    }

    //3. Initialize action bar
    private fun initActionBar() {
        setSupportActionBar(findViewById(R.id.tbSignIn))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = ""
        }
    }

    //7. panggil fungsi validasi input
    private fun isValidInput(email: String, pass: String): Boolean {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailSignIn.error = "Invalid Email Format"
            return false
        }

        if (pass.length < 6) {
            etPasswordSignIn.error = "Password must be at least 6 characters"
            return false
        }
        return true
    }

    //10. login to server
    private fun loginToServer(email: String, pass: String) {
        CustomDialog.showLoading(this)
        val credential = EmailAuthProvider.getCredential(email, pass)
        //11. panggil fungsi firebase auth
        fireBaseAuth(credential)
    }

    //11. panggil fungsi firebase auth
    private fun fireBaseAuth(credential: AuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                CustomDialog.hideLoading()
                if (task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                }else{
                    Toast.makeText(this, "Sign-In failed", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {exception ->
                CustomDialog.hideLoading()
                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
            }
    }
}