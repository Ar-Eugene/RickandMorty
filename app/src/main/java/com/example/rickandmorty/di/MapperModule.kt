package com.example.rickandmorty.di

import com.example.rickandmorty.data.mapper.MapperCharacter
import org.koin.dsl.module

val mapperModule = module {
    single { MapperCharacter() }
}