package com.example.codingtest.presentation.features.photos.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.codingtest.databinding.FragmentPhotosBinding
import com.example.codingtest.domain.model.PhotoModel
import com.example.codingtest.presentation.base.BaseFragment
import com.example.codingtest.presentation.features.photos.list.adapter.PhotosAdapter
import com.example.codingtest.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding, CountryViewModel>(FragmentPhotosBinding::inflate) {
    override val viewModel: CountryViewModel by viewModels()
    private var adapter: PhotosAdapter? = null
    private var countryList = mutableListOf<PhotoModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpViewModel()
    }

    private fun setUpViews() {
        setUpRecycler()
    }

    private fun setUpViewModel() {
        viewModel.photosResult.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> {
                    binding?.pgCenter?.visibility = View.INVISIBLE
                    it.errorObject?.message?.let { msg -> showFailToast(msg) }
                }

                is UiState.Loading -> {
                    binding?.pgCenter?.visibility = View.VISIBLE
                }

                is UiState.Success -> {
                    countryList = it.value.toMutableList()
                    binding?.pgCenter?.visibility = View.INVISIBLE
                    adapter?.setItems(it.value)
                }
                else -> {
                    binding?.pgCenter?.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun setUpRecycler() {
        binding?.apply {
            adapter = PhotosAdapter(onItemClick = { item ->
                navigateTo(PhotosFragmentDirections.actionPhotosFragmentToPhotoDetailsFragment(item))
            }, onLikeClick = { item ->
                adapter?.updateItem(item)
            })
            rvCountries.adapter = adapter
        }
    }
}