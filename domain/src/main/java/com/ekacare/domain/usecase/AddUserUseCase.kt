package com.ekacare.domain.usecase

import com.ekacare.data.entity.User
import com.ekacare.data.repository.UserRepository

class AddUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user: User) {
        userRepository.insert(user)
    }
}