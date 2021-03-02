package expect

import kotlin.test.*

fun <T> expect(value: T) = Expectation(value)

inline fun <T> expect(value: T, builder: Expectation<T>.() -> Unit) = expect(value).apply(builder)

inline fun <reified T> Expectation<*>.toBeInstanceOf() = assertTrue(
    """
        
    Expected : ${T::class.simpleName}
    Actual   : $value
    =================================
    
    """.trimIndent()
) {
    value is T
}

inline fun <T> Expectation<T>.toBeNonNull() = assertNotNull(value)

fun <T> Expectation<T>.toBeNull() = assertNull(value)

infix fun <T> Expectation<T>.toBe(expected: T) = assertEquals(expected, value)

inline fun <reified T> Expectation<*>.toBe() = toBeInstanceOf<T>()

infix fun <T> Expectation<T>.toBeEqualTo(expected: T) = toBe(expected)

infix fun <T> Expectation<T>.toBeUnequalTo(expected: T) = assertNotEquals(expected, value)