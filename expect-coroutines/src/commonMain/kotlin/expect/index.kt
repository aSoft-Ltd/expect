package expect

import kotlinx.coroutines.flow.StateFlow

inline fun <E> expect(sf: StateFlow<E>) = StateFlowAssertion(sf)

inline fun <E> expectState(
    sf: StateFlow<E>,
    builder: StateFlowAssertion<E>.() -> Unit
) = StateFlowAssertion(sf).apply(builder)