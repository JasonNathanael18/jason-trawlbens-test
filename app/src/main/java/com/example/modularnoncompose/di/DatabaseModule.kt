package com.example.modularnoncompose.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.RepoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RepoDatabase::class.java,
        "REPO_DATABASE"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: RepoDatabase) = database.repoDao()

}