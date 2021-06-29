package expect

import kotlin.test.assertTrue

/**
 * @param E Expected Type
 *
 * Samples
 *
 */
interface CollectionExpectation<E> : BasicExpectation<Collection<E>> {

    fun toContain(vararg elements: E) = assertTrue(
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

    fun toNotContain(vararg elements: E) = assertTrue(
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

    fun toBeEmpty() = assertTrue(
        """
    
    Expected   : Collection to be empty
    Collection : [
        ${value.joinToString(separator = "\n        ") { it.toString() }}
    ]
    ===============================================
    """.trimIndent()
    ) { value.isEmpty() }

    fun toContainElements() = assertTrue(
        """
    
    Expected   : Collection to contain elements
    Collection : Collection was empty
    ===============================================
    """.trimIndent()
    ) { value.isNotEmpty() }

    fun toHave(length: Int) = assertTrue(
        """
    
    Expected : $length to be length of the collection
    Actual   : ${value.size} is the length of the collection
    ===============================================
    """.trimIndent()
    ) { value.size == length }

    fun toBeOfSize(size: Int) = assertTrue(
        """
    
    Expected : $size to be size of the collection
    Actual   : ${value.size} is the size of the collection
    ===============================================
    """.trimIndent()
    ) { value.size == size }
}