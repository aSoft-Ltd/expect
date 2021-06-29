package expect

import kotlin.js.JsExport

@JsExport
actual open class BasicAssertion<E> actual constructor(override val value: E) : BasicExpectation<E>