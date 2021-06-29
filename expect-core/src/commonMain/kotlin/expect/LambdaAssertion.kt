package expect

import kotlin.js.JsExport

@JsExport
class LambdaAssertion(override val value: () -> Unit) : BasicAssertion<() -> Unit>(value), LambdaExpectation