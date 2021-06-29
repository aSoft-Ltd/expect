package expect

import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

inline fun <reified T> BasicExpectation<*>.toBeInstanceOf() = assertTrue(
    """
        
    Expected : ${T::class.simpleName}
    Actual   : $value
    =================================
    
    """.trimIndent()
) {
    value is T
}

inline fun <reified T> BasicExpectation<*>.toBe() = toBeInstanceOf<T>()

infix fun <T> BasicExpectation<T>.toBeEqualTo(expected: T) = toBe(expected)

infix fun <T> BasicExpectation<T>.toBeUnequalTo(expected: T) = assertNotEquals(expected, value)