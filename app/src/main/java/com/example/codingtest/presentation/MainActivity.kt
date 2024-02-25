package com.example.codingtest.presentation

import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding
import com.example.codingtest.databinding.ActivityMainBinding
import com.example.codingtest.presentation.base.BaseActivity
import com.example.codingtest.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
    override val viewBinding: ViewBinding by viewBinding(ActivityMainBinding::inflate)

    override fun setUpView() {
        super.setUpView()
    }
}