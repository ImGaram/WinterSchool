package com.example.winterschool.fb_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.winterschool.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val btn = findViewById<Button>(R.id.login_btn)
        btn.setOnClickListener {
            auth.signInAnonymously().addOnCompleteListener(this) { task->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("mainactivity", user!!.uid)
                } else {
                    Toast.makeText(this, "안됨", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}