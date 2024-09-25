package org.coffee.ui.screen.auth

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import kotlinx.coroutines.delay
import org.coffee.testUI.SubscribeBox
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class LoginContentKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test() {
        composeTestRule.apply {

            setContent {
                LoginContent()
            }

            composeTestRule.mainClock.advanceTimeBy(2000)

           // onNode(hasText("Forgot password")).performClick()


        //    composeTestRule.onNodeWithText("Forgot password").performClick()

         //   composeTestRule.mainClock.advanceTimeBy(4000)
       /*     onNode(hasText("Email address"))
                .performTextInput("test@gmail.com")

            onNode(hasText("Password"))
                .performTextInput("test")



            onNode(hasText("Login"))
                .performClick()


            onNode(hasText("Register"))
                .performClick()


                   onNode(hasText("You successfully subscribed"))
                .assertIsDisplayed()

*/


            // click button that triggers a navigation to next screen
       //     composeTestRule.onNodeWithText("Forgot password").performClick()
            // check whether next screen displays
            composeTestRule.waitUntil(2000) {
                composeTestRule.onNodeWithText("Forgot password").isDisplayed()
                //composeTestRule.onNode(hasTestTag("forgot"), useUnmergedTree = true).isDisplayed()
            }
            // click button that triggers a navigation to next next screen
         //   composeTestRule.onNodeWithText(nextNextButtonText).performClick()
            // check whether next next screen displays
         //   composeTestRule.waitUntil(1000) { testRule.onNodeWithText(nextNextScreenTitle).assertExists()}


        }
    }

}