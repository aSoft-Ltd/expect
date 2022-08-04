package expect.internal

import expect.BasicExpectation
import expect.CollectionExpectation
import kotlin.test.assertTrue

/**
 * @param E Expected Type
 *
 * Samples
 *
 */
@PublishedApi
internal class CollectionExpectationImpl<E>(
    override val value: Collection<E>
) : CollectionExpectation<E>, BasicExpectation<Collection<E>> by BasicExpectationImpl(value) {
    override fun toContain(vararg elements: E) = assertTrue(
        """
            
            Expected   : ${
            elements.joinToString(
                ",",
                prefix = "[",
                postfix = "]"
            ) { it.toString() }
        } to be inside the collection
            Collection : [
                ${value.joinToString(separator = "\n        ") { it.toString() }}
            ]
            ===============================================
    """.trimIndent()
    ) { value.containsAll(elements.toList()) }

    override fun toNotContain(vararg elements: E) = assertTrue(
        """
    
        Expected   : ${
            elements.joinToString(
                ",",
                prefix = "[",
                postfix = "]"
            ) { it.toString() }
        } to not be inside the collection
        Collection : [
            ${value.joinToString(separator = "\n        ") { it.toString() }}
        ]
        ===============================================
        """.trimIndent()
    ) { !value.containsAll(elements.toList()) }

    override fun toBeEmpty() = assertTrue(
        """
    
    Expected   : Collection to be empty
    Collection : [
        ${value.joinToString(separator = "\n        ") { it.toString() }}
    ]
    ===============================================
    """.trimIndent()
    ) { value.isEmpty() }

    override fun toContainElements() = assertTrue(
        """
    
    Expected   : Collection to contain elements
    Collection : Collection was empty
    ===============================================
    """.trimIndent()
    ) { value.isNotEmpty() }

    override fun toHave(length: Int) = assertTrue(
        """
    
    Expected : $length to be length of the collection
    Actual   : ${value.size} is the length of the collection
    ===============================================
    """.trimIndent()
    ) { value.size == length }

    override fun toBeOfSize(size: Int) = assertTrue(
        """
    
    Expected : $size to be size of the collection
    Actual   : ${value.size} is the size of the collection
    ===============================================
    """.trimIndent()
    ) { value.size == size }
}