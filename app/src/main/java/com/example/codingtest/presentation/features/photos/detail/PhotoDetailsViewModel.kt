package com.example.codingtest.presentation.features.photos.detail

import com.example.codingtest.domain.usecase.GetPhotosUseCase
import com.example.codingtest.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoDetailsViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
) : BaseViewModel() {}