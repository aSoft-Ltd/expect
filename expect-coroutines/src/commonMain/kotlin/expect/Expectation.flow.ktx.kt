package expect

import kotlinx.coroutines.flow.StateFlow
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

fun <S> BasicExpectation<out StateFlow<S>>.toBe(expected: S) = assertEquals(expected, value.value)

fun <S> BasicExpectation<out StateFlow<S>>.toBeNull() = assertEquals<S?>(null, value.value)

fun <S> BasicExpectation<out StateFlow<S>>.toBeNonNull() = assertNotNull(value.value)