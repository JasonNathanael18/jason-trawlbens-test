package com.example.data.repoimpl

import com.example.data.apiservice.ApiService
import com.example.data.mapper.ProfileMapper
import com.example.data.mapper.RepoListItemMapper
import com.example.data.utils.NetworkBoundResource
import com.example.data.utils.mapFromApiResponse
import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.ProfileUseCase
import com.example.domain.usecase.RepoListUseCase
import com.example.entity.ProfileEntity
import com.example.entity.RepoItemEntity
import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkBoundResources: NetworkBoundResource,
    private val repositoryListItemMapper: RepoListItemMapper,
    private val profileMapper: ProfileMapper
) : GithubRepository {

    override suspend fun fetchRepoList(params: RepoListUseCase.Params): Flow<Result<List<RepoItemEntity>>> {
        return mapFromApiResponse(
            result = networkBoundResources.downloadData {
                apiService.fetchRepoList(
                    params.userName,
                    params.perPage,
                    params.page
                )
            }, repositoryListItemMapper
        )
    }

    override suspend fun fetchProfile(params: ProfileUseCase.Params): Flow<Result<ProfileEntity>> {
        return mapFromApiResponse(
            result = networkBoundResources.downloadData {
                apiService.fetchProfile(params.userName)
            }, profileMapper
        )
    }

}