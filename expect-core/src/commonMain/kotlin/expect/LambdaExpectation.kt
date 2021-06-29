package expect

interface LambdaExpectation : BasicExpectation<() -> Unit> {
    fun toFail(): Throwable {
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


    fun toPass() {
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
}