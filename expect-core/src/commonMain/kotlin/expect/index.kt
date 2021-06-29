package expect

inline fun <E> expect(value: E) = BasicAssertion(value)

inline fun <E> expect(vararg value: E) = CollectionAssertion(value.asList())

inline fun <E> expect(collection: Collection<E>) = CollectionAssertion(collection)

inline fun <E> expect(
    value: E,
    builder: BasicExpectation<E>.() -> Unit
): BasicExpectation<out E> = expect(value).apply(builder)

fun expect(lambda: () -> Unit) = LambdaAssertion(lambda)

inline fun <E> expectMany(
    value: Collection<E>,
    builder: CollectionExpectation<E>.() -> Unit
): CollectionExpectation<out E> = expect(value).apply(builder)
