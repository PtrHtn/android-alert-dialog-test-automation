package com.ptrhtn.androidalertdialoguitestautomation

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferencesService = SharedPreferencesService(application)

}