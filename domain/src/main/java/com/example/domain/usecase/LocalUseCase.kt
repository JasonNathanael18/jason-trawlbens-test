package com.example.domain.usecase

import com.example.domain.repository.LocalDataSource
import com.example.domain.repository.RepoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalUseCase @Inject constructor(
    private val localRepo: LocalDataSource
){

    suspend fun insertRecipes(recipesEntity: RepoEntity) {
        localRepo.insertRepo(recipesEntity)
    }

    fun readRecipes(): Flow<List<RepoEntity>> {
        return localRepo.readRepo()
    }
}