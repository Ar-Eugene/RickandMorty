package com.example.rickandmorty.di

import com.example.rickandmorty.presentation.view_model.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(characterInteractor = get())
    }

}