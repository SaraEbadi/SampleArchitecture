package com.example.codingtest.presentation.features.photos.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.codingtest.domain.model.PhotoModel
import com.example.codingtest.domain.usecase.GetPhotosUseCase
import com.example.codingtest.presentation.base.BaseViewModel
import com.example.codingtest.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
) : BaseViewModel() {

    private val _photosResult = MutableLiveData<UiState<List<PhotoModel>>>()
    val photosResult: LiveData<UiState<List<PhotoModel>>> = _photosResult

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            _photosResult.value = UiState.Loading
            try {
                val countries = getPhotosUseCase()
                _photosResult.value = UiState.Success(countries ?: emptyList())
            } catch (e: Exception) {
                _photosResult.value = UiState.Error(handleUniversalServerError(e))
            }
        }
    }
}