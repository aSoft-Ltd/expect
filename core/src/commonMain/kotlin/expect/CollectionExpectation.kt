package expect

/**
 * @param E Expected Type
 *
 * Samples
 *
 */
interface CollectionExpectation<out E> : BasicExpectation<Collection<E>> {
    fun toContain(vararg elements: @UnsafeVariance E)

    fun toNotContain(vararg elements: @UnsafeVariance E)

    fun toBeEmpty()

    fun toContainElements()

    fun toHave(length: Int)

    fun toBeOfSize(size: Int)
}