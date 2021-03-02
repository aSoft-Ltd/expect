package expect

import kotlin.test.assertFails

fun Expectation<() -> Unit>.toFail() {
    var failed = false
    try {
        value()
    } catch (_: Throwable) {
        failed = true
    } finally {
        if (failed) return
        throw AssertionError("Expected lambda to fail, but did not")
    }
}


fun Expectation<() -> Unit>.toPass() {
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