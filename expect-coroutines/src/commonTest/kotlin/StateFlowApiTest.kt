import kotlinx.coroutines.flow.MutableStateFlow
import expect.expect
import expect.toBe
import expect.toBeNonNull
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