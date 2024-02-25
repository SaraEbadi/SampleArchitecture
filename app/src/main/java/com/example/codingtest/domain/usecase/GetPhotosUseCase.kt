package com.example.codingtest.domain.usecase

import com.example.codingtest.data.repository.PhotosRepository
import com.example.codingtest.domain.model.PhotoModel
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
private val repository: PhotosRepository
)  {
    suspend operator fun invoke(): List<PhotoModel>? {
        return repository.getPhotos(10, 10)
    }
}