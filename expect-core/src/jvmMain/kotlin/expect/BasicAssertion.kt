package expect

import kotlin.test.assertTrue

actual open class BasicAssertion<E> actual constructor(override val value: E) : BasicExpectation<E> {

    fun toBeInstanceOf(clazz: Class<*>) = assertTrue(
        """
		
	    Expected : instance of ${clazz.simpleName}
	    Actual   : instance of ${value!!::class.simpleName}
	    =================================
	    
	    """.trimIndent()
    ) { clazz.isInstance(value) }
}
