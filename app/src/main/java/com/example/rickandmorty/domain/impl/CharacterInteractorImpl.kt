package com.example.rickandmorty.domain.impl

import com.example.rickandmorty.data.dto.CharacterRequest
import com.example.rickandmorty.domain.interactor.CharacterInteractor
import com.example.rickandmorty.domain.repository.CharacterRepository
import com.example.rickandmorty.domain.models.Character as RickAndMortyCharacter

class CharacterInteractorImpl(
    private val repository: CharacterRepository
) : CharacterInteractor {

    override suspend fun getCharacters(request: CharacterRequest): List<RickAndMortyCharacter> {
        return repository.getCharacters(request)
    }

    override suspend fun getCharacter(id: Int): RickAndMortyCharacter {
        return repository.getCharacter(id)
    }
}