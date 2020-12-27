package com.example.tdmobile.domain.usecases

import com.example.tdmobile.data.repository.UserRepository
import com.example.tdmobile.domain.entity.User

class GetUserUseCase(private val userRepository: UserRepository) {

    suspend fun invoke(email: String) : User {

        return userRepository.getUser(email)
    }


}