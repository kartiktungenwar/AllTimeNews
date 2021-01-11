package com.alltimenews.utill

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context?) {

    private var context: Context? = null
    private var prefs: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private val PREFS_NAME = "Watermark"


    fun connectDB() {
        prefs = context!!.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = prefs?.edit()
    }

    fun closeDB() {
        editor!!.commit()
    }

    fun setInt(key: String?, value: Int) {
        editor!!.putInt(key, value)
    }

    fun getInt(key: String?): Int {
        return prefs!!.getInt(key, 0)
    }

    fun setFloat(key: String?, value: Float) {
        editor!!.putFloat(key, value)
    }

    fun getFloat(key: String?): Float {
        return prefs!!.getFloat(key, 0f)
    }

    fun setBoolean(key: String?, value: Boolean) {
        editor!!.putBoolean(key, value)
    }

    fun getBoolean(key: String?): Boolean {
        return prefs!!.getBoolean(key, false)
    }

    fun setString(key: String?, value: String?) {
        editor!!.putString(key, value)
    }

    fun getString(key: String?): String? {
        return prefs!!.getString(key, "")
    }
}