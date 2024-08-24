package com.filipeneri.bipamobilecodingchallenge.di

import com.filipeneri.bipamobilecodingchallenge.repository.MainRepository
import com.filipeneri.bipamobilecodingchallenge.ui.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.dsl.single

class AppModule {
    val appModule = module{
        viewModelOf(::MainViewModel)
        factory { MainRepository() }
    }
}