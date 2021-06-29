package expect

class LambdaAssertion(override val value: () -> Unit) : BasicAssertion<() -> Unit>(value), LambdaExpectation