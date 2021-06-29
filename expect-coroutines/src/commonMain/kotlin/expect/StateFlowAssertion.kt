package expect

import kotlinx.coroutines.flow.StateFlow
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class StateFlowAssertion<E>(
    override val value: StateFlow<E>
) : BasicAssertion<StateFlow<E>>(value), StateFlowExpectation<E>