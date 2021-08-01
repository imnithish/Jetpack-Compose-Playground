package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.google.accompanist.insets.ProvideWindowInsets
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.helpers.EmptyInAppReviewHelper
import com.steleot.jetpackcompose.playground.theme.ColorPalette
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import org.junit.Rule
import org.junit.Test

class ButtonScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val inAppReviewHelper = EmptyInAppReviewHelper()

    @Test
    fun testButtonScreen() {
        composeTestRule.setContent {
            JetpackComposePlaygroundTheme(
                colorPalette = ColorPalette.DEEP_PURPLE
            ) {
                ProvideWindowInsets {
                    CompositionLocalProvider(LocalInAppReviewer provides inAppReviewHelper) {
                        ButtonScreen()
                    }
                }
            }
        }

        composeTestRule
            .onNodeWithText("Default Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Cut Corner Shape Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Rounded Corner Shape Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Background Color Button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("Fake Button")
            .assertDoesNotExist()
    }
}