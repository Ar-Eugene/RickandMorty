package com.example.rickandmorty.di

import com.example.rickandmorty.data.impl.CharacterRepositoryImpl
import com.example.rickandmorty.domain.repository.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<CharacterRepository> {
        CharacterRepositoryImpl(api = get(),mapper = get())
    }

}