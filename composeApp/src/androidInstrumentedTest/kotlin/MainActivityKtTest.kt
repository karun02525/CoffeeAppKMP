import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.coffee.testUI.SubscribeBox
import org.junit.Rule
import org.junit.Test

class MainActivityKtTest{

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun test(){
       composeTestRule.apply {

           setContent {
               SubscribeBox()
           }

           onNode(hasText("Enter your email"))
               .performTextInput("test@gmail.com")

           onNode(hasText("SUBSCRIBE"))
               .performClick()

           onNode(hasText("You successfully subscribed"))
               .assertIsDisplayed()



       }
    }

}