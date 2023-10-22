package com.example.domain.utils

import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface UseCase

interface ApiUseCaseParams<Params, Type> : UseCase {
    suspend fun execute(params: Params): Flow<Result<Type>>
}

interface ApiUseCaseNonParams<Type> : UseCase {
    suspend fun execute(): Flow<Result<Type>>
}
