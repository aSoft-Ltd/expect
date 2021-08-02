package expect

class SuspendLambdaAssertion(
    override val value: suspend () -> Unit
) : BasicAssertion<suspend () -> Unit>(value), SuspendLambdaExpectation