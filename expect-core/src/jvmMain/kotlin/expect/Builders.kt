package expect

object Builders {
    @JvmStatic
    fun <E> expect(collection: Collection<E>) = CollectionAssertion(collection)

    @JvmStatic
    fun <E> expect(value: E) = BasicAssertion(value)

    @JvmStatic
    fun expect(func: Callback): LambdaExpectation = LambdaAssertion(func::execute)
}