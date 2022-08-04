package expect

import kotlin.test.assertTrue

/**
 * @param E Expected Type
 *
 * Samples
 *
 */
actual interface BasicExpectation<out E> {
    actual val value: E

    actual fun toBeNonNull(message: String)

    actual fun toBeNonNull()

    actual fun toBeNull(message: String)

    actual fun toBeNull()

    actual fun toBe(expected: @UnsafeVariance E, message: String)

    actual fun toBe(expected: @UnsafeVariance E)

    fun toBeInstanceOf(clazz: Class<*>) {
        assertTrue(
            """
		
	    Expected : instance of ${clazz.simpleName}
	    Actual   : instance of ${value!!::class.simpleName}
	    =================================
	    
	    """.trimIndent()
        ) { clazz.isInstance(value) }
    }
}