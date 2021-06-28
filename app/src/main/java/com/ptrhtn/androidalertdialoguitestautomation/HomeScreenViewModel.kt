package com.ptrhtn.androidalertdialoguitestautomation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferencesService = SharedPreferencesService(application)

    val radioButtonChoice by lazy { MutableLiveData<String>() }

    fun getRadioButtonChoice() {
        radioButtonChoice.value = sharedPreferencesService.getRadioButtonChoice()
    }

    fun setRadioButtonChoice(radioButtonValue: String) {
        sharedPreferencesService.save("radioButtonChoice", radioButtonValue)
        radioButtonChoice.value = radioButtonValue
    }

}