package com.ptrhtn.androidalertdialoguitestautomation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import android.app.AlertDialog
import android.widget.*
import androidx.lifecycle.Observer


class HomeScreenFragment : Fragment() {
    private lateinit var homeScreenViewModel: HomeScreenViewModel

    private val radioWaveValueObserver = Observer<String>{radioWaveValue ->
        radioWaveValue?.let {
            view?.findViewById<TextView>(R.id.home_screen_radio_buttons_value_textView)?.text = radioWaveValue
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentHomeScreen = inflater.inflate(R.layout.fragment_home_screen, container, false)

        fragmentHomeScreen.findViewById<LinearLayout>(R.id.home_screen_radio_buttons_layout).setOnClickListener {
            openRadioButtonsDialog()
        }

        return fragmentHomeScreen    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeScreenViewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)
        homeScreenViewModel.radioButtonChoice.observe(
                viewLifecycleOwner,
                radioWaveValueObserver
        )
        homeScreenViewModel.getRadioButtonChoice()
    }

    private fun openRadioButtonsDialog() {

        val radioButtonChoices = arrayOf("AM", "FM")
        var reSelectedRadioButton = ""
        var selectedRadioButton = when (homeScreenViewModel.radioButtonChoice.value) {
            "AM" -> 0
            "FM" -> 1
            else -> 1
        }

        val alertDialogBuilder = AlertDialog.Builder(context)
        with(alertDialogBuilder)
        {
            setTitle("Radio Buttons")
            setSingleChoiceItems(radioButtonChoices, selectedRadioButton) { _, which ->
                reSelectedRadioButton = radioButtonChoices[which]
            }


            setPositiveButton("Set it") { _, _ ->

                if (reSelectedRadioButton.isNotBlank()) {
                    homeScreenViewModel.setRadioButtonChoice(reSelectedRadioButton)
//                    Toast.makeText(context, "Radio wave changed to $reSelectedRadioButton", Toast.LENGTH_LONG).show()
                }
            }
            setNegativeButton("Cancel", null)
            show()

        }
    }

}