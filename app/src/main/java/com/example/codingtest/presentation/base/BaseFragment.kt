package com.example.codingtest.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding, V : BaseViewModel?>(private val bindingInflater: ((LayoutInflater) -> T)) :
    Fragment() {
    protected var binding: T? = null
    protected abstract val viewModel: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater(inflater)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun navigateTo(uri: NavDirections) {
        findNavController().navigate(uri)
    }

    fun popBackStack(){
        findNavController().popBackStack()
    }

    fun showFailToast(msg: String, length: Int = Toast.LENGTH_LONG) {
        val toast = Toast.makeText(requireContext(), msg, length)
        toast.show()
    }
}