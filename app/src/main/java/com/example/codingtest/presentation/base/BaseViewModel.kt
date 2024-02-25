package com.example.codingtest.presentation.base
import androidx.lifecycle.ViewModel
import com.example.codingtest.utils.ErrorObject
import retrofit2.HttpException

open class BaseViewModel : ViewModel(){
    fun handleUniversalServerError(error: Throwable): ErrorObject {
        return when (error) {
            is HttpException -> {
                ErrorObject(error.message, cause = error)
            }
//            is NoConnectivityException -> {
//                ErrorObject("No Internet Connection!", cause = error)
//            }
            else -> {
                ErrorObject(error.message, cause = error)
            }
        }
    }
}