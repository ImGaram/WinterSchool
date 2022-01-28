package com.example.winterschool.diet_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.example.winterschool.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        try {
            Log.d("tag", auth.currentUser!!.uid)
            Toast.makeText(this, "원래 비회원 로그인이 되어있는 사람이다.", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                startActivity(Intent(this, MainPageActivity::class.java))
                finish()
            }, 3000)
        } catch (e: Exception) {

            Log.d("tag", "회원가입이 필요함")

            auth.signInAnonymously().addOnCompleteListener(this) { task->
                if (task.isSuccessful) {
                    Toast.makeText(this, "비회원 로그인 성공.", Toast.LENGTH_SHORT).show()

                    Handler().postDelayed({
                        startActivity(Intent(this, MainPageActivity::class.java))
                        finish()
                    }, 3000)
                } else {
                    Toast.makeText(this, "안됨", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}