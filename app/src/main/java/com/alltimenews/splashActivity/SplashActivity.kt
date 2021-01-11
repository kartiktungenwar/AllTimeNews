package com.alltimenews.splashActivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.alltimenews.R
import com.alltimenews.countryActivity.CountryActivity
import com.alltimenews.mainActivity.MainActivity

class SplashActivity : AppCompatActivity() {

    private val timeOut = 3000
    private var handler: Handler? = null
    private val isFirstTime = false
    private var i: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()


        handler = Handler()
        handler!!.postDelayed(Runnable {

          i = if (!isFirstTime) {
              Intent(this@SplashActivity, CountryActivity::class.java)
                  .setFlags(
                      Intent.FLAG_ACTIVITY_CLEAR_TOP or
                              Intent.FLAG_ACTIVITY_CLEAR_TASK or
                              Intent.FLAG_ACTIVITY_NEW_TASK
                  )
          } else {
              Intent(this@SplashActivity, MainActivity::class.java)
                  .setFlags(
                      Intent.FLAG_ACTIVITY_CLEAR_TOP or
                              Intent.FLAG_ACTIVITY_CLEAR_TASK or
                              Intent.FLAG_ACTIVITY_NEW_TASK
                  )
          }
            startActivity(i)
        }, timeOut.toLong())

    }
}