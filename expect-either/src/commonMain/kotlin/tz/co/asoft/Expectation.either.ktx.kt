package tz.co.asoft

import kotlin.test.*

inline fun <reified L, reified R> Expectation<*>.toBeEither(): Either<L, R> {
    assertTrue(
        """
            
    Expected : [${L::class.simpleName} | ${R::class.simpleName}]
    Actual   : $value
    =============================================================

    """.trimIndent()
    ) {
        value is L || value is R
    }
    return value.asEither()
}