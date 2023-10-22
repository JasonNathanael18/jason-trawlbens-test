package com.example.feature_favourite

import com.example.router.FeatureScreenFavouriteRouteContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FeatureFavouriteModule {

    @Singleton
    @Provides
    fun providesFeatureFavouriteRouteContract(): FeatureScreenFavouriteRouteContract =
        FeatureFavouriteRouteContractImpl()
}