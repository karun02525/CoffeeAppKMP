import androidx.test.core.app.ApplicationProvider
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class SimpleTest {

    @Test
    fun testPackage(){
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        assertThat(context.packageName).isEqualTo("org.coffee")
    }
}