package expect.internal

import expect.BasicExpectation
import expect.SuspendLambdaExpectation

@PublishedApi
internal class SuspendLambdaExpectationImpl(
    override val value: suspend () -> Unit
) : SuspendLambdaExpectation, BasicExpectation<suspend () -> Unit> by BasicExpectationImpl(value) {
    override suspend fun toFail(): Throwable {
        var throwable: Throwable? = null
        try {
            value()
        } catch (cause: Throwable) {
            throwable = cause
        } finally {
            if (throwable != null) return throwable
            throw AssertionError("Expected lambda to fail, but did not")
        }
    }


    override suspend fun toPass() {
        var passed = false
        try {
            value()
            passed = true
        } catch (_: Throwable) {
            passed = false
        } finally {
            if (passed) return
            throw AssertionError("Expected lambda to pass, but did not")
        }
    }
}