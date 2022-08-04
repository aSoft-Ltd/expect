package expect

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
expect annotation class NativeIgnore()
