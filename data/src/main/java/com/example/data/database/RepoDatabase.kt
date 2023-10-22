package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.repository.RepoEntity

@Database(
    entities = [RepoEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(RepoTypeConverter::class)
abstract class RepoDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao

}