package com.ptrhtn.androidalertdialoguitestautomation

import android.content.Context

class SharedPreferencesService(context: Context) {

    private val sharedPreferences =
            context.getSharedPreferences("AndroidAlertDialog_SharedPreferences", Context.MODE_PRIVATE)

    fun getRadioWave(): String? {
        return when (sharedPreferences.getString("radioWave", "FM").isNullOrBlank()) {
            true -> "FM"
            false -> sharedPreferences.getString("radioWave", "FM")
        }
    }
}