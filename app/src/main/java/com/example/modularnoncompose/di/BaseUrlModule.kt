package com.example.modularnoncompose.di

import com.example.di.qualifier.AppBaseUrl
import com.example.modularnoncompose.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule{
    @Provides
    @AppBaseUrl
    fun provideBaseUrl():String = BuildConfig.base_url
}