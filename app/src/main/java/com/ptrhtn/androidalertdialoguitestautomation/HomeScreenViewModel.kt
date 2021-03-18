package com.ptrhtn.androidalertdialoguitestautomation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferencesService = SharedPreferencesService(application)

    val radioWave by lazy { MutableLiveData<String>() }

    fun getRadioWave() {
        radioWave.value = sharedPreferencesService.getRadioWave()
    }

}