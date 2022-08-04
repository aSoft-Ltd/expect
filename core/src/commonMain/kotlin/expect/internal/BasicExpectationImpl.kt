package expect.internal

import expect.BasicExpectation
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class BasicExpectationImpl<E>(override val value: E) : BasicExpectation<E> {
    override fun toBeNonNull(message: String) {
        assertNotNull(value, message)
    }

    override fun toBeNonNull() {
        assertNotNull(value)
    }

    override fun toBeNull() = assertNull(value)

    override fun toBeNull(message: String) = assertNull(value, message)

    override fun toBe(expected: @UnsafeVariance E, message: String) = assertEquals(expected, value, message)

    override fun toBe(expected: E) = assertEquals(expected, value)
}