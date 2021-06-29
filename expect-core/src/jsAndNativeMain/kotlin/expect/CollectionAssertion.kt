package expect

import kotlin.js.JsExport

@JsExport
actual class CollectionAssertion<E> actual constructor(
    override val value: Collection<E>
) : BasicAssertion<Collection<E>>(value), CollectionExpectation<E>