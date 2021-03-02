package expect

import kotlin.test.*

inline fun <E> expect(vararg elements: E) = expect(elements.toList())

//inline fun <E> expect(vararg elements: E, builder: Expectation<Collection<E>>.() -> Unit) = expect(elements.toList(), builder)

fun <E> Expectation<Collection<E>>.toContain(vararg elements: E) = assertTrue(
    """
    
    Expected   : ${elements.joinToString(",", prefix = "[", postfix = "]") { it.toString() }} to be inside the collection
    Collection : [
        ${value.joinToString(separator = "\n        ") { it.toString() }}
    ]
    ===============================================
""".trimIndent()
) { value.containsAll(elements.toList()) }

fun <T> Expectation<Collection<T>>.toNotContain(vararg elements: T) {
    assertTrue(
        """
    
    Expected   : ${elements.joinToString(",", prefix = "[", postfix = "]") { it.toString() }} to not be inside the collection
    Collection : [
        ${value.joinToString(separator = "\n        ") { it.toString() }}
    ]
    ===============================================
""".trimIndent()
    ) { !value.containsAll(elements.toList()) }
}

fun <E> Expectation<Collection<E>>.toBeEmpty() = assertTrue(
    """
    
    Expected   : Collection to be empty
    Collection : [
        ${value.joinToString(separator = "\n        ") { it.toString() }}
    ]
    ===============================================
""".trimIndent()
) { value.isEmpty() }

fun <E> Expectation<Collection<E>>.toContainElements() = assertTrue(
    """
    
    Expected   : Collection to contain elements
    Collection : Collection was empty
    ===============================================
""".trimIndent()
) { value.isNotEmpty() }

fun <E> Expectation<Collection<E>>.toHave(length: Int) = assertTrue(
    """
    
    Expected : $length to be length of the collection
    Actual   : ${value.size} is the length of the collection
    ===============================================
""".trimIndent()
) { value.size == length }

fun <E> Expectation<Collection<E>>.toBeOfSize(size: Int) = assertTrue(
    """
    
    Expected : $size to be size of the collection
    Actual   : ${value.size} is the size of the collection
    ===============================================
""".trimIndent()
) { value.size == size }