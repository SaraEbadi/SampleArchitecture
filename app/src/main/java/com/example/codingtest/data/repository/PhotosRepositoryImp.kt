package com.example.codingtest.data.repository

import com.example.codingtest.data.data_source.PhotosRemoteDataSource
import com.example.codingtest.domain.model.PhotoModel
import javax.inject.Inject

class PhotosRepositoryImp @Inject constructor(
    private val cloudDataSource: PhotosRemoteDataSource,
) : PhotosRepository {

    override suspend fun getPhotos(page: Int, perPage: Int): List<PhotoModel>? {
        return cloudDataSource.getPhotos(page, perPage)
    }
}