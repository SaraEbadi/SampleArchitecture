package com.example.codingtest.data.mapper

import com.example.codingtest.data.model.PhotoDto
import com.example.codingtest.data.model.Urls
import com.example.codingtest.data.model.User
import com.example.codingtest.domain.mapper.DomainMapper
import com.example.codingtest.domain.model.PhotoModel
import javax.inject.Inject

class PhotoMapper @Inject constructor() : DomainMapper<PhotoDto, PhotoModel> {
    override fun mapToDomainModel(model: PhotoDto): PhotoModel {
        return PhotoModel(model.id, model.independent, model.createdAt, model.user?.username, model.urls?.full, model.user?.bio )
    }

    override fun mapFromDomainModel(domainModel: PhotoModel): PhotoDto {
        return PhotoDto(domainModel.id, domainModel.independent, domainModel.createdAt, Urls(domainModel.url), User(domainModel.username, bio = domainModel.bio))
    }

    fun toDomainList(initial: List<PhotoDto>): List<PhotoModel> {
        return initial.map { mapToDomainModel(it) }
    }
}