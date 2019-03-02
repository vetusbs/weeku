package io.weeku.domain.usecase

interface UseCase<in I, out O> {
    fun execute(input: I): O
}
