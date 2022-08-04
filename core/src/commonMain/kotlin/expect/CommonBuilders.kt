@file:JvmName("Expect")
@file:JvmSynthetic

package expect

import expect.internal.BasicExpectationImpl
import expect.internal.CollectionExpectationImpl
import expect.internal.LambdaExpectationImpl
import functions.Runnable
import kotlin.jvm.JvmName
import kotlin.jvm.JvmSynthetic

fun <E> expect(value: E): BasicExpectation<E> = BasicExpectationImpl(value)

fun <E> expect(vararg value: E): CollectionExpectation<E> = CollectionExpectationImpl(value.asList())

fun <E> expectArray(array: Array<E>) = expect(*array)

fun <E> expectCollection(collection: Collection<E>): CollectionExpectation<E> = CollectionExpectationImpl(collection)


fun <E> expect(collection: Collection<E>) = expectCollection(collection)

inline fun <E> expect(
    value: E,
    builder: BasicExpectation<E>.() -> Unit
): BasicExpectation<E> = expect(value).apply(builder)

fun expectFunction(lambda: Runnable): LambdaExpectation = LambdaExpectationImpl(lambda::run)

inline fun <E> expectMany(
    value: Collection<E>,
    builder: CollectionExpectation<E>.() -> Unit
): CollectionExpectation<E> = expectCollection(value).apply(builder)