package com.example.sprintshoestap

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    val PREFS_NAME = "coocki"

    val mSharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

fun agregarPrefs(kayPrefs: String){

    mSharedPreferences.edit().putString(kayPrefs,kayPrefs).apply()
}

    fun clean(){
        mSharedPreferences.edit().clear().apply()
    }

    fun removeItem(kayEliminar : String) {
    mSharedPreferences.edit().remove(kayEliminar).apply()
}
    fun showAll(): String {
        return mSharedPreferences.all.toString()
    }
}