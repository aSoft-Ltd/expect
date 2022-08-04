package expect

import expect.internal.BasicExpectationImpl
import expect.internal.CollectionExpectationImpl
import expect.internal.LambdaExpectationImpl

object ExpectBuilders {
    @JvmStatic
    fun <E> expect(value: E): BasicExpectation<E> = BasicExpectationImpl(value)

    @JvmStatic
    fun <E> expect(vararg value: E): CollectionExpectation<E> = CollectionExpectationImpl(value.asList())

    @JvmStatic
    fun <E> expectArray(array: Array<E>) = expect(*array)

    @JvmStatic
    fun <E> expectCollection(collection: Collection<E>): CollectionExpectation<E> = CollectionExpectationImpl(collection)

    @JvmStatic
    fun expectFunction(lambda: Runnable): LambdaExpectation = LambdaExpectationImpl(lambda::run)
}