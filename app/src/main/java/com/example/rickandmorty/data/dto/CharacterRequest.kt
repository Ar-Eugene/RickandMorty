package com.example.rickandmorty.data.dto

import com.example.rickandmorty.domain.models.Origin
import com.example.rickandmorty.domain.models.enums.Gender
import com.example.rickandmorty.domain.models.enums.Status

class CharacterRequest(
    val page: Int = 1,
    val name: String? = null,
    val status: Status? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: Gender? = null,
    val origin: Origin? = null,
    val location: LocationDto? = null,
    val image: String? = null,
    val episode: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)