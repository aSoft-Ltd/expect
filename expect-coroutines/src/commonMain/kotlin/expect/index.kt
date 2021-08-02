package expect

import kotlinx.coroutines.flow.StateFlow

inline fun <E> expect(sf: StateFlow<E>) = StateFlowAssertion(sf)

fun expect(lambda: suspend () -> Unit) = SuspendLambdaAssertion(lambda)

suspend fun expectFailure(lambda: suspend () -> Unit) = expect(lambda).toFail()

inline fun <E> expectState(
    sf: StateFlow<E>,
    builder: StateFlowAssertion<E>.() -> Unit
) = StateFlowAssertion(sf).apply(builder)