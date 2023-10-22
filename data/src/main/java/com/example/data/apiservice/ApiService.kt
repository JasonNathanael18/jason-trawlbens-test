package com.example.data.apiservice

import com.example.apiresponse.ProfileApiResponse
import com.example.apiresponse.RepoItemApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/users/{username}/repos")
    suspend fun fetchRepoList(
        @Path("username")username:String,
        @Query("per_page")perPage: Int,
        @Query("page")page: Int,
    ): Response<List<RepoItemApiResponse>>

    @GET("/users/{username}")
    suspend fun fetchProfile(
        @Path("username")username:String
    ):Response<ProfileApiResponse>
}