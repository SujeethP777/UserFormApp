package com.ekacare.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ekacare.domain.usecase.AddUserUseCase

class UserViewModelFactory(private val usecase: AddUserUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(usecase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
