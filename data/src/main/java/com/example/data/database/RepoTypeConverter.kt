package com.example.data.database

import androidx.room.TypeConverter
import com.example.entity.RepoItemEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RepoTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun repoToString(repo: RepoItemEntity): String {
        return gson.toJson(repo)
    }

    @TypeConverter
    fun stringToRepo(repoString: String): RepoItemEntity {
        val objectType = object : TypeToken<RepoItemEntity>() {}.type
        return gson.fromJson(repoString, objectType)
    }

}