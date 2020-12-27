package com.example.tdmobile.injection


import android.content.Context
import androidx.room.Room
import com.example.tdmobile.data.local.AppDatabase
import com.example.tdmobile.data.local.DatabaseDAO
import com.example.tdmobile.data.repository.UserRepository
import com.example.tdmobile.domain.usecases.CreateUserUseCase
import com.example.tdmobile.domain.usecases.GetUserUseCase
import com.example.tdmobile.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {

    factory { MainViewModel(get(), get()) }
}

val domainModule = module {

    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {

    single { UserRepository(get()) }
    single { createDataBase(androidContext())}
}

fun createDataBase(context: Context): DatabaseDAO {

    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ) .build()
    return appDatabase.databaseDAO()
}
