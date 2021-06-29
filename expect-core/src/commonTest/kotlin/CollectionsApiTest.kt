import expect.expect
import expect.expectMany
import expect.toBe
import kotlin.test.Test

class CollectionsApiTest {
    @Test
    fun should_have_a_killer_api() {
        expect(listOf(1, 2, 3, 4)).toContain(2, 3, 4)
    }

    @Test
    fun can_use_variable_arguments() {
        expect(1, 2, 3, 4, 5).toContain(1, 5)
    }

    @Test
    fun can_check_length_of_multiple_things() {
        expectMany(listOf(1, 2, 3, 4, 5)) {
            toContain(2, 3, 4)
            toHave(length = 5)
            toBe<List<*>>()
        }
    }
}