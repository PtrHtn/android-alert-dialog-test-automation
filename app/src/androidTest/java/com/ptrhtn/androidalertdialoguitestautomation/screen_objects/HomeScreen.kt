package com.ptrhtn.androidalertdialoguitestautomation.screen_objects

import com.agoda.kakao.common.views.KView
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.screens.KScreen
import com.ptrhtn.androidalertdialoguitestautomation.HomeScreenFragment
import com.ptrhtn.androidalertdialoguitestautomation.R

object HomeScreen : KScreen<HomeScreen>() {
    override val layoutId: Int?
        get() = R.layout.fragment_home_screen
    override val viewClass: Class<*>?
        get() = HomeScreenFragment::class.java

    val homeScreenTitle = KView { withText("Android Alert Dialogs")}

    val radioButtonsLayout = KView { withId(R.id.home_screen_radio_buttons_layout)}
    val radioButtonsTitle = KTextView{ withId(R.id.home_screen_radio_buttons_title_textView)}
    val radioButtonsDescription = KTextView { withId(R.id.home_screen_radio_buttons_description_textView)}
    val textRadioButton = KTextView{withId(R.id.home_screen_radio_button_text_textView)}
    val radioButtonsValue = KTextView { withId(R.id.home_screen_radio_buttons_value_textView)}

}