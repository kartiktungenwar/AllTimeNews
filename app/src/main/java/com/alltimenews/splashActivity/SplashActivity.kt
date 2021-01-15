package com.alltimenews.splashActivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.alltimenews.R
import com.alltimenews.countryActivity.CountryActivity
import com.alltimenews.mainActivity.MainActivity
import com.alltimenews.utill.Constant
import com.alltimenews.utill.SharedPreferenceManager

class SplashActivity : AppCompatActivity(), Constant {

    private val timeOut = 3000
    private var handler: Handler? = null
    private var isFirstTime = false
    private var i: Intent? = null
    private var sharedPreferenceManager: SharedPreferenceManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        sharedPreferenceManager = SharedPreferenceManager(this);

        handler = Handler()
        handler!!.postDelayed(Runnable {

            sharedPreferenceManager?.connectDB()
            isFirstTime = sharedPreferenceManager!!.getBoolean(FIRST_TIME)
            sharedPreferenceManager?.closeDB()

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