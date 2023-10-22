package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertRepo(repoEntity: RepoEntity)
    fun readRepo(): Flow<List<RepoEntity>>
}