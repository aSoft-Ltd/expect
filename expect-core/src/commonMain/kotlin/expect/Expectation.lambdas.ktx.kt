package expect

import kotlin.test.assertFails

fun BasicExpectation<() -> Unit>.toFail(): Throwable {
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


fun BasicExpectation<() -> Unit>.toPass() {
    var passed = false
    passed = try {
        value()
        true
    } catch (_: Throwable) {
        true
    } finally {
        if (passed) return
        throw AssertionError("Expected lambda to pass, but did not")
    }
}

inline fun expectFailure(block: () -> Unit) = assertFails(block)