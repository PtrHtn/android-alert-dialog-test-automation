package com.ptrhtn.androidalertdialoguitestautomation.ui_tests

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.ptrhtn.androidalertdialoguitestautomation.MainActivity
import com.ptrhtn.androidalertdialoguitestautomation.screen_objects.HomeScreen
import org.junit.Rule
import org.junit.Test

@LargeTest
class HomeScreenUiTests : TestCase() {
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun shouldDisplayAllHomeScreenViews_asExpected() {
        before {
            activityTestRule.launchActivity(null)
        }.after {
        }.run {
            step("Open Home screen and check title") {
                HomeScreen { homeScreenTitle.isDisplayed() }
            }
        }
    }

    @Test
    fun shouldDisplayAllHomeScreenViews_asExpected_inLandscapeMode() {
        before {
            device.uiDevice.setOrientationLeft()
            activityTestRule.launchActivity(null)
        }.after {
            device.uiDevice.setOrientationNatural()
        }.run {
            step("Open Home screen and check title") {
                HomeScreen { homeScreenTitle.isDisplayed() }
            }
        }
    }

}