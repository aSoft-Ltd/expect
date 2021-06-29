package expect

actual class CollectionAssertion<E> actual constructor(
    override val value: Collection<E>
) : BasicAssertion<Collection<E>>(value), CollectionExpectation<E>