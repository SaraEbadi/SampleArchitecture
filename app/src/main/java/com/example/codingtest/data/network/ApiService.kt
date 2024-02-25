package com.example.codingtest.data.network

import com.example.codingtest.data.model.PhotoDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(@Query("client_id") accessKey: String,
                          @Query("page") page: Int,
                          @Query("per_page") perPage: Int): Deferred<List<PhotoDto>>
}