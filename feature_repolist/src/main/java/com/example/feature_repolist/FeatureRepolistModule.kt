package com.example.feature_repolist

import com.example.router.FeatureScreenRepoListRouteContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FeatureRepolistModule {

    @Singleton
    @Provides
    fun providesFeatureRepolistRouteContract(): FeatureScreenRepoListRouteContract =
        FeatureRepoListRouteContractImpl()
}