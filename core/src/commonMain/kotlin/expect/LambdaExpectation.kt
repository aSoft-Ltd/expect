package expect

interface LambdaExpectation : BasicExpectation<() -> Unit> {
    fun toFail(): Throwable

    fun toPass()
}