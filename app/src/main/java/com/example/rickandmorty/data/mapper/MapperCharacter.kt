package com.example.rickandmorty.data.mapper

import com.example.rickandmorty.data.dto.CharacterDto
import com.example.rickandmorty.data.dto.OriginDto
import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.models.Origin
import com.example.rickandmorty.domain.models.enums.Gender
import com.example.rickandmorty.domain.models.enums.Status

fun CharacterDto.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        status = when (status.lowercase()) {
            "alive" -> Status.ALIVE
            "dead" -> Status.DEAD
            else -> Status.UNKNOWN
        },
        species = species,
        type = type,
        gender = when (gender.lowercase()) {
            "male" -> Gender.MALE
            "female" -> Gender.FEMALE
            "genderless" -> Gender.GENDERLESS
            else -> Gender.UNKNOWN
        },
        origin = origin.toDomain()
    )
}

fun OriginDto.toDomain(): Origin {
    return Origin(
        name = name,
        url = url
    )
}