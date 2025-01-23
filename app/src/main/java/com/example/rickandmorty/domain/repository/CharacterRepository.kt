package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.data.dto.CharacterRequest
import com.example.rickandmorty.domain.models.Character

interface CharacterRepository {
    suspend fun getCharacters(request: CharacterRequest): List<Character>
    suspend fun getCharacter(id: Int): Character
}