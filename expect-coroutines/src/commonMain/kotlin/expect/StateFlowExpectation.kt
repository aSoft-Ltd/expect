package expect

import kotlinx.coroutines.flow.StateFlow
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

interface StateFlowExpectation<E> : BasicExpectation<StateFlow<E>> {
    fun toBeAt(expected: E) = assertEquals(expected, value.value)

    override fun toBeNull() = assertEquals<E?>(null, value.value)

    override fun toBeNonNull() {
        assertNotNull(value.value)
    }
}