package com.example.rickandmorty.data.impl

import com.example.rickandmorty.data.CharacterApi
import com.example.rickandmorty.data.dto.CharacterRequest
import com.example.rickandmorty.data.mapper.MapperCharacter
import com.example.rickandmorty.domain.repository.CharacterRepository
import com.example.rickandmorty.domain.models.Character as RickAndMortyCharacter

class CharacterRepositoryImpl(
    private val api: CharacterApi,
    private val mapper: MapperCharacter
) : CharacterRepository {

    override suspend fun getCharacters(request: CharacterRequest): List<RickAndMortyCharacter> {
        val response = api.getCharacters(request.page)
        return mapper.mapToCharacterList(response.results)
    }

    override suspend fun getCharacter(id: Int): RickAndMortyCharacter {
        val characterDto = api.getCharacter(id)
        return mapper.mapToCharacter(characterDto)
    }
}