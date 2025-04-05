package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //1. deklarasi button logout
    private lateinit var btnLogout: Button

    //8. deklarasi firebase auth
    private lateinit var mGoogleSignInClient:GoogleSignInClient

    //2. deklarasi firebase auth
    private lateinit var auth: FirebaseAuth
    //private lateinit var mGoogleSignInClient:GoogleSignInClient

    //4. deklarasi text view
    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. panggil fungsi logout
        btnLogout = findViewById(R.id.btnLogout)

        //4. panggil fungsi text view
        tvEmail = findViewById(R.id.tvEmail)


        //3. panggil fungsi firebase auth
        initFirebaseAuth()

        //5. get data User
        getData()

        //1. panggil fungsi logout
        btnLogout.setOnClickListener {
            // 7. Panggil fungsi logout dari Firebase Authentication
            auth.signOut()

            //8. Panggil fungsi logout dari Google Sign In
            mGoogleSignInClient.signOut().addOnCompleteListener {
                Toast.makeText(this, "Success Logout", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    //3. panggil fungsi firebase auth
    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()

        //8.  Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    //5. get data User
    private fun getData() {
        val user = auth.currentUser
        if (user != null){
            tvEmail.text = user.email
        }
    }

}