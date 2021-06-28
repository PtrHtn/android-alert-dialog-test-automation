package com.ptrhtn.androidalertdialoguitestautomation

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesService(context: Context) {

    private val sharedPreferences =
            context.getSharedPreferences("AndroidAlertDialog_SharedPreferences", Context.MODE_PRIVATE)

    fun getRadioButtonChoice(): String? {
        return when (sharedPreferences.getString("radioButtonChoice", "FM").isNullOrBlank()) {
            true -> "FM"
            false -> sharedPreferences.getString("radioButtonChoice", "FM")
        }
    }

    fun save(key: String, value: String) {

        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        with(editor) {
            putString(key, value)
            apply()
        }
    }
}