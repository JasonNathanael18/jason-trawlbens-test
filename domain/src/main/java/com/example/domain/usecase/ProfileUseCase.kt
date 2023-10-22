package com.example.domain.usecase

import com.example.domain.repository.GithubRepository
import com.example.domain.utils.ApiUseCaseParams
import com.example.domain.utils.Result
import com.example.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val repository: GithubRepository
):ApiUseCaseParams<ProfileUseCase.Params, ProfileEntity>{
    data class Params(val userName:String)
    override suspend fun execute(params: Params): Flow<Result<ProfileEntity>> {
        return repository.fetchProfile(params)
    }
}