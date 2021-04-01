package com.ptrhtn.androidalertdialoguitestautomation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import android.app.Activity
import android.Manifest
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer


class HomeScreenFragment : Fragment() {
    private lateinit var homeScreenViewModel: HomeScreenViewModel

    private val radioWaveValueObserver = Observer<String>{radioWaveValue ->
        radioWaveValue?.let {
            view?.findViewById<TextView>(R.id.home_screen_radio_buttons_value_textView)?.text = radioWaveValue
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeScreenViewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)
        homeScreenViewModel.radioWave.observe(
                viewLifecycleOwner,
                radioWaveValueObserver
        )
        homeScreenViewModel.getRadioWave()
    }

}