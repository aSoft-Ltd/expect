import expect.expectFunction
import kotlin.test.Test

class LambdaTest {
    @Test
    fun should_fail() {
        expectFunction {
            TODO()
        }.toFail()
    }
}