package com.example.codingtest.presentation.features.photos.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.codingtest.databinding.FragmentPhotoDetailsBinding
import com.example.codingtest.presentation.base.BaseFragment
import com.example.codingtest.utils.glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoDetailsFragment : BaseFragment<FragmentPhotoDetailsBinding, PhotoDetailsViewModel>(FragmentPhotoDetailsBinding::inflate) {
    override val viewModel: PhotoDetailsViewModel by viewModels()
    private val args: PhotoDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setOnClick()
        setupViewModel()
    }

    private fun setOnClick() {
        binding?.ivBack?.setOnClickListener { popBackStack() }
    }

    private fun setupViews() {
        binding?.apply {
            ivPhoto.glide(args.photo.url)
            tvUsername.text = args.photo.username
            tvBio.text = args.photo.bio
        }
    }

    private fun setupViewModel() {}
}