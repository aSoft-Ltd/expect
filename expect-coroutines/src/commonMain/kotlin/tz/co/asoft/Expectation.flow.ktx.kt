package tz.co.asoft

import kotlinx.coroutines.flow.StateFlow
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

fun <S> Expectation<StateFlow<S>>.toBe(expected: S) = assertEquals(expected, value.value)

fun <S> Expectation<StateFlow<S>>.toBeNull() = assertEquals<S?>(null, value.value)

fun <S> Expectation<StateFlow<S>>.toBeNonNull() = assertNotNull(value.value)