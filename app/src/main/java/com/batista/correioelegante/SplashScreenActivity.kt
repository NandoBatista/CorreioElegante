package com.batista.correioelegante

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

        private lateinit var handler: Handler
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash_screen)
            supportActionBar?.hide()

            handler = Handler()
            handler.postDelayed({

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }, @Suppress("MagicNumber")
                3000)
        }
    }

