package com.example.tdmobile.domain.usecases

import com.example.tdmobile.data.repository.UserRepository
import com.example.tdmobile.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {

    suspend fun invoke(user: User) {

        userRepository.createUser(user)
    }
}