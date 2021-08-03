@file:JvmSynthetic

package expect

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmName
import kotlin.jvm.JvmSynthetic

@JsExport
inline fun <E> expect(value: E) = BasicAssertion(value)

@JsExport
@JsName("expectArray")
inline fun <E> expect(vararg value: E) = CollectionAssertion(value.asList())

@JvmName("expectArray")
fun <E> expect(array: Array<E>) = expect(*array)

inline fun <E> expect(collection: Collection<E>) = CollectionAssertion(collection)

inline fun <E> expect(
    value: E,
    builder: BasicExpectation<E>.() -> Unit
): BasicExpectation<out E> = expect(value).apply(builder)

@JsExport
@JsName("expectFunction")
fun expectFunction(lambda: () -> Unit) = LambdaAssertion(lambda)

inline fun <E> expectMany(
    value: Collection<E>,
    builder: CollectionExpectation<E>.() -> Unit
): CollectionExpectation<out E> = expect(value).apply(builder)