package com.example.modularnoncompose.di

import com.example.data.database.LocalDataSourceImpl
import com.example.data.repoimpl.GithubRepoImpl
import com.example.domain.repository.GithubRepository
import com.example.domain.repository.LocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {

    @Binds
    fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

}