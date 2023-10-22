package com.example.feature_detail

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.router.FeatureScreenDetailRouteContract

@Module
@InstallIn(SingletonComponent::class)
class FeatureDetailModule {

    @Singleton
    @Provides
    fun providesFeatureDetailRouteContract(): FeatureScreenDetailRouteContract =
        FeatureDetailRouteContractImpl()
}