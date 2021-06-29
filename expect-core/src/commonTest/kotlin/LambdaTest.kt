import expect.expect
import kotlin.test.Test

class LambdaTest {
    @Test
    fun should_fail() {
        expect {
            TODO()
        }.toFail()
    }
}