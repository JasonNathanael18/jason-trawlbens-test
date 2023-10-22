package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.repository.RepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepo(recipesEntity: RepoEntity)

    @Query("SELECT * FROM repo_table ORDER BY id ASC")
    fun readRepo(): Flow<List<RepoEntity>>

}