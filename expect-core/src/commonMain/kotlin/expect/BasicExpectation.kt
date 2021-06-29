package expect

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * @param E Expected Type
 *
 * Samples
 *
 */
interface BasicExpectation<E> {
    val value: E

    fun toBeNonNull() = assertNotNull(value)

    fun toBeNull() = assertNull(value)

    fun toBe(expected: E) = assertEquals(expected, value)
}