package expect

import kotlin.test.assertIs

inline fun <reified T:Throwable> LambdaExpectation.toFailWith() : T {
    val failed = toFail()
    assertIs<T>(failed)
    return failed
}