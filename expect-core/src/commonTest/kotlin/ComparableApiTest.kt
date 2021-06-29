import expect.*
import kotlin.test.Test

class ComparableApiTest {
    @Test
    fun should_have_a_killer_api() {
        expect(1 + 1).toBe(2)
        expect(2 + 2) {
            toBeEqualTo(4)
            toBeLessThan(5)
            toBeGreaterThan(1)
            toBeNonNull()
            toBe<Int>()
            toBe<Number>()
            toBe<Comparable<*>>()
        }
    }
}