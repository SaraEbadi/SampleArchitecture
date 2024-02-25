package com.example.codingtest.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity() {
    abstract val viewModel: V
    abstract val viewBinding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        setUpView()
        setUpViewModel()
    }

    open fun setUpView() {}

    open fun setUpViewModel() {}
}