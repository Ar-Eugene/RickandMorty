package com.example.rickandmorty.data

import com.example.rickandmorty.data.dto.CharacterDto
import com.example.rickandmorty.data.dto.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int? = null): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDto
}
