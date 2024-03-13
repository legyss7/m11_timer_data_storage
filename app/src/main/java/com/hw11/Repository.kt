package com.hw11

import android.content.Context
import android.util.Log

private const val PREFERENCE_NAME = "preference_name"
private const val SHARED_PREFS_KEY = "shared_pref_key"

class Repository(private var localValue: String? = null) {

    private fun getDataFromSharedPreference(context: Context): String? {
        val prefs = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        Log.d("myLog", prefs.getString(SHARED_PREFS_KEY, null).toString())
        return prefs.getString(SHARED_PREFS_KEY, null)
    }

    private fun getDataFromLocalVariable(): String? {
        Log.d("myLog", localValue.toString())
        return localValue
    }

    fun saveText(context: Context, text: String) {
        val prefs = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(SHARED_PREFS_KEY, text)
        editor.apply()
        localValue = text
    }

    fun clearText(context: Context) {
        val prefs = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.remove(SHARED_PREFS_KEY)
        editor.apply()
        localValue = null
    }

    fun getText(context: Context): String {
        return when {
            getDataFromLocalVariable() != null -> getDataFromLocalVariable()!!
            getDataFromSharedPreference(context) != null -> getDataFromSharedPreference(context)!!
            else -> "no one source doesn't contain string"
        }
    }
}