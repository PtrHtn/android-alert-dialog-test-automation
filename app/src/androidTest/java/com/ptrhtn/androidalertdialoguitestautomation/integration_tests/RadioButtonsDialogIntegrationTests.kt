package com.ptrhtn.androidalertdialoguitestautomation.integration_tests

import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.ptrhtn.androidalertdialoguitestautomation.MainActivity
import org.junit.Rule

class RadioButtonsDialogIntegrationTests  : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)
}