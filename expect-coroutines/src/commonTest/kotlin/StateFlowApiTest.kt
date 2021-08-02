import expect.expect
import expect.expectState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.test.Test

class StateFlowApiTest {
    val state = MutableStateFlow(5)

    @Test
    fun should_have_killer_api() {
        expect(state).toBeAt(5)
    }

    @Test
    fun should_test_multiple() {
        expectState(state) {
            toBeAt(5)
            toBeNonNull()
        }
    }
}