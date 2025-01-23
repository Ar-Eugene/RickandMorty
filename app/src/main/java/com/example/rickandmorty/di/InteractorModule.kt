package com.example.rickandmorty.di

import com.example.rickandmorty.domain.impl.CharacterInteractorImpl
import com.example.rickandmorty.domain.interactor.CharacterInteractor
import org.koin.dsl.module

val interactorModule = module {

    factory<CharacterInteractor> {
        CharacterInteractorImpl(repository = get())
    }

}