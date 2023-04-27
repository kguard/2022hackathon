package com.kguard.hackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val account = FirebaseAuth.getInstance().currentUser
        if (account !== null) {
            lifecycleScope.launchWhenCreated {
                delay(2000L)
                Intent(this@SplashActivity, MainActivity::class.java).also {
                    startActivity(it)
                    this@SplashActivity.finish()
                }
            }
        } else if (account == null) {
            lifecycleScope.launchWhenCreated {
                delay(2000L)
                Intent(this@SplashActivity, LoginActivity::class.java).also {
                    startActivity(it)
                    this@SplashActivity.finish()
                }
            }
        }
    }
}
