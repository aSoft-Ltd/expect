import expect.expect
import kotlin.test.Test

class ResolutionAmbiguityTest {
    @Test
    fun expect_should_be_resolved_without_ambiguity() {
        expect(1 + 1).toBe(2)
    }
}