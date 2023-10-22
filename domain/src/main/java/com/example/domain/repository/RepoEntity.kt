package com.example.domain.repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.entity.RepoItemEntity

@Entity(tableName = "repo_table")
class RepoEntity(
    var repo: RepoItemEntity
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}