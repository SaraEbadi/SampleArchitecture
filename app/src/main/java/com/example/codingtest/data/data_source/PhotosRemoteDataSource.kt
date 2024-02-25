package com.example.codingtest.data.data_source

import com.example.codingtest.data.model.PhotoDto
import com.example.codingtest.domain.model.PhotoModel

interface PhotosRemoteDataSource {
    suspend fun getPhotos(page: Int, perPage: Int): List<PhotoModel>
}