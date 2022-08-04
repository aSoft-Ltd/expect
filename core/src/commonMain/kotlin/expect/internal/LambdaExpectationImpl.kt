package expect.internal

import expect.BasicExpectation
import expect.LambdaExpectation

internal class LambdaExpectationImpl(
    override val value: () -> Unit
) : LambdaExpectation, BasicExpectation<() -> Unit> by BasicExpectationImpl(value) {
    override fun toFail(): Throwable {
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


    override fun toPass() {
        var passed = false
        passed = try {
            value()
            true
        } catch (_: Throwable) {
            false
        } finally {
            if (passed) return
            throw AssertionError("Expected lambda to pass, but did not")
        }
    }
}