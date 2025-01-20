package com.example.rickandmorty.data.dto

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDto
)

data class OriginDto(
    val name: String,
    val url: String
)
