package io.weeku.domain.usecase

interface UseCase<I, O> {
    fun execute(input: I): O
}
