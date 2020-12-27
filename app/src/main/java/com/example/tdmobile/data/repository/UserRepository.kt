package com.example.tdmobile.data.repository

import com.example.tdmobile.data.local.DatabaseDAO
import com.example.tdmobile.data.local.models.toData
import com.example.tdmobile.data.local.models.toEntity
import com.example.tdmobile.domain.entity.User

class UserRepository(private val databaseDAO: DatabaseDAO) {

    suspend fun createUser(user: User) {

        databaseDAO.insert(user.toData())
    }

    fun getUser(email: String) : User {

        val userLocal = databaseDAO.findByName(email)
        return userLocal.toEntity()
    }
}