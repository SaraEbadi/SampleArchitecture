package com.example.codingtest.data.data_source

import com.example.codingtest.data.mapper.PhotoMapper
import com.example.codingtest.data.model.PhotoDto
import com.example.codingtest.data.network.ApiService
import com.example.codingtest.domain.model.PhotoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotosRemoteDataSourceImp @Inject constructor(
    private val apiService: ApiService,
    private val mapper: PhotoMapper
) : PhotosRemoteDataSource {
    override suspend fun getPhotos(page: Int, perPage: Int): List<PhotoModel> {
        return mapper.toDomainList(apiService.getPhotos(BuildConfig.FETCH_PHOTO_KEY, page, perPage))
    }
}