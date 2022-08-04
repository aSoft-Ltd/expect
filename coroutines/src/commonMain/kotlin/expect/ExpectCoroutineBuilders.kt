package expect

import expect.internal.SuspendLambdaExpectationImpl

fun expectLambda(lambda: suspend () -> Unit): SuspendLambdaExpectation = SuspendLambdaExpectationImpl(lambda)

suspend fun expectFailure(lambda: suspend () -> Unit) = expectLambda(lambda).toFail()

suspend inline fun <reified T : Throwable> expectFailureWith(noinline lambda: () -> Unit) = expectLambda(lambda).toFailWith<T>()