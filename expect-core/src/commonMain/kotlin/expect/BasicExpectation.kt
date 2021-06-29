package expect

import kotlin.contracts.contract
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/**
 * @param E Expected Type
 *
 * Samples
 *
 */
interface BasicExpectation<E> {
    val value: E

    fun toBeNonNull() {
        assertNotNull(value)
    }

    fun toBeNull() = assertNull(value)

    fun toBe(expected: E) = assertEquals(expected, value)
}