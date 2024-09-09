package com.ekacare.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekacare.data.entity.User
import com.ekacare.domain.usecase.AddUserUseCase
import kotlinx.coroutines.launch

class UserViewModel(private val usecase: AddUserUseCase) : ViewModel() {

    fun addUser(name: String, age: Int, dob: String, address: String) {
        val user = User(name = name, age = age, dob = dob, address = address)
        viewModelScope.launch {
            usecase.invoke(user)
        }
    }
}