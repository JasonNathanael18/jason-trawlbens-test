package com.example.domain.usecase

import com.example.domain.repository.GithubRepository
import com.example.domain.utils.ApiUseCaseParams
import com.example.domain.utils.Result
import com.example.entity.RepoItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoListUseCase @Inject constructor(
    private val repository: GithubRepository
) : ApiUseCaseParams<RepoListUseCase.Params, List<RepoItemEntity>> {
    override suspend fun execute(params: Params): Flow<Result<List<RepoItemEntity>>> {
        return repository.fetchRepoList(params)
    }

    data class Params(
        val userName: String,
        val perPage: Int = 10,
        val page: Int = 1
    )
}