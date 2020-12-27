package tz.co.asoft

import kotlin.test.assertTrue

fun <T : Comparable<T>> Expectation<T>.toBeGreaterThan(expected: T) = assertTrue(
    """
        
    Expected : $value to be greater than $expected
    =============================
   
    """.trimIndent()
) {
    value > expected
}

fun <T : Comparable<T>> Expectation<T>.toBeGreaterThanOrEqualTo(expected: T) = assertTrue(
    """
        
    Expected : $value to be grater or equal to $expected
    ==============================
   
    """.trimIndent()
) {
    value >= expected
}

fun <T : Comparable<T>> Expectation<T>.toBeLessThan(expected: T) = assertTrue(
    """
        
    Expected : $value to be less than $expected
    =============================
   
    """.trimIndent()
) {
    value < expected
}

fun <T : Comparable<T>> Expectation<T>.toBeLessThanOrEqualTo(expected: T) = assertTrue(
    """
        
    Expected : $value to be less than or equal to $expected
    ==============================
   
    """.trimIndent()
) {
    value <= expected
}