package com.example.aisleassignment.prefs

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    companion object{
        private lateinit var preferences: SharedPreferences
        fun init(context: Context){
            preferences = context.getSharedPreferences("AISLE_SESSION", Context.MODE_PRIVATE)
        }

        fun saveString(key: String, value: String) {
            preferences.edit().putString(key, value).apply()
        }

        fun getString(key: String): String? {
            return preferences.getString(key, null)
        }
    }
}