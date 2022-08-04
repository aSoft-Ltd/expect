package expect

import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

inline fun <reified E> BasicExpectation<*>.toBeInstanceOf(message: String? = null): BasicExpectation<E> {
    assertIs<E>(value, message)
    return this as BasicExpectation<E>
}

inline fun <reified E> BasicExpectation<*>.toBe(): E = toBeInstanceOf<E>().value

inline fun <E> BasicExpectation<E>.toBeEqualTo(expected: E, message: String? = null) = assertEquals(expected, value, message)

inline fun <T> BasicExpectation<T>.toBeUnequalTo(expected: T, message: String? = null) = assertNotEquals(expected, value, message)