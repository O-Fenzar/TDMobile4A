package com.example.tdmobile.injection


import org.koin.dsl.module

val presentationModule = module {

    factory {MainViewModel()}
}


