package com.example.rickandmorty.domain.models

import com.example.rickandmorty.domain.models.enums.Gender
import com.example.rickandmorty.domain.models.enums.Status

data class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: Origin
)
data class Origin(
    val name: String,
    val url: String
)
