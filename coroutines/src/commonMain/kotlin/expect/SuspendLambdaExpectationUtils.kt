package expect

import kotlin.test.assertIs

suspend inline fun <reified T : Throwable> SuspendLambdaExpectation.toFailWith(): T {
    val failed = toFail()
    assertIs<T>(failed)
    return failed
}