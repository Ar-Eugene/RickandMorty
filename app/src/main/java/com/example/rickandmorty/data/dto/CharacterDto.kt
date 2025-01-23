package com.example.rickandmorty.data.dto

data class CharacterDto(
    val id: Int = 0,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val origin: OriginDto? = null,
    val image: String? = null,
    val location: LocationDto? = null
)

data class OriginDto(
    val name: String,
    val url: String
)

data class LocationDto(
    val name: String,
    val url: String
)

