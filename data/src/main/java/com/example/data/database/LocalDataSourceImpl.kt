package com.example.data.database

import com.example.domain.repository.LocalDataSource
import com.example.domain.repository.RepoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val repoDao: RepoDao
) : LocalDataSource {

    override suspend fun insertRepo(repoEntity: RepoEntity) {
        repoDao.insertRepo(repoEntity)
    }

    override fun readRepo(): Flow<List<RepoEntity>> {
        return repoDao.readRepo()
    }
}