package expect

/**
 * @param E Expected Type
 *
 * Samples
 *
 */
expect interface BasicExpectation<out E> {
    val value: E

    fun toBeNonNull(message: String)

    fun toBeNonNull()

    fun toBeNull(message: String)

    fun toBeNull()

    fun toBe(expected: @UnsafeVariance E, message: String)

    fun toBe(expected: @UnsafeVariance E)
}