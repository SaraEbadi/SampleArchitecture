package com.example.codingtest.data.repository

import com.example.codingtest.domain.model.PhotoModel

interface PhotosRepository {
    suspend fun getPhotos(page: Int, perPage: Int): List<PhotoModel>?
}