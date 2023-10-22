package com.example.domain.repository

import com.example.domain.usecase.ProfileUseCase
import com.example.domain.usecase.RepoListUseCase
import com.example.entity.ProfileEntity
import com.example.entity.RepoItemEntity
import kotlinx.coroutines.flow.Flow
import com.example.domain.utils.Result


interface GithubRepository {
    suspend fun fetchRepoList(params: RepoListUseCase.Params): Flow<Result<List<RepoItemEntity>>>
    suspend fun fetchProfile(params: ProfileUseCase.Params):Flow<Result<ProfileEntity>>
}