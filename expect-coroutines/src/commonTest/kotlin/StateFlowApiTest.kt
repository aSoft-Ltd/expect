import kotlinx.coroutines.flow.MutableStateFlow
import tz.co.asoft.expect
import tz.co.asoft.toBe
import tz.co.asoft.toBeNonNull
import tz.co.asoft.toBeNull
import kotlin.test.Test

class StateFlowApiTest {
    @Test
    fun should_have_killer_api() {
        val state = MutableStateFlow(5)
        expect(state) {
            toBe(5)
            toBeNonNull()
        }
    }
}