package expect

import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

inline fun <reified E> BasicExpectation<Any?>.toBeInstanceOf(message: String? = null): BasicExpectation<E> {
    assertIs<E>(value, message)
    return this as BasicExpectation<E>
}

inline fun <reified E> BasicExpectation<Any?>.toBe(): E = toBeInstanceOf<E>().value

inline fun <E> BasicExpectation<E>.toBeEqualTo(expected: E, message: String? = null) = assertEquals(expected, value, message)

inline fun <T> BasicExpectation<T>.toBeUnequalTo(expected: T, message: String? = null) = assertNotEquals(expected, value, message)

inline fun BasicExpectation<String?>.toContain(other: String, ignoreCase: Boolean = true) = assertTrue(
    message = "Expected $value to contain $other"
) {
    value?.contains(other, ignoreCase) == true
}