package com.example.rickandmorty.data.mapper

import com.example.rickandmorty.data.dto.CharacterDto
import com.example.rickandmorty.data.dto.LocationDto
import com.example.rickandmorty.data.dto.OriginDto
import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.models.Location
import com.example.rickandmorty.domain.models.Origin
import com.example.rickandmorty.domain.models.enums.Gender
import com.example.rickandmorty.domain.models.enums.Status

class MapperCharacter {

    // Преобразование CharacterDto -> Character
    fun mapToCharacter(dto: CharacterDto): Character {
        return Character(
            id = dto.id,
            name = dto.name ?: "",
            status = when (dto.status?.uppercase()) {
                "ALIVE" -> Status.ALIVE
                "DEAD" -> Status.DEAD
                else -> Status.UNKNOWN
            },
            species = dto.species ?: "",
            type = dto.type ?: "",
            gender = when (dto.gender?.uppercase()) {
                "MALE" -> Gender.MALE
                "FEMALE" -> Gender.FEMALE
                "GENDERLESS" -> Gender.GENDERLESS
                else -> Gender.UNKNOWN
            },
            origin = mapToOrigin(dto.origin ?: OriginDto("", "")),
            image = dto.image ?: "",
            location = mapToLocation(dto.location ?: LocationDto("", ""))
        )
    }

    // Преобразование OriginDto -> Origin
    private fun mapToOrigin(dto: OriginDto): Origin {
        return Origin(
            name = dto.name,
            url = dto.url
        )
    }

    fun mapToLocation(dto: LocationDto): Location {
        return Location(
            name = dto.name,
            url = dto.url
        )
    }

    // Преобразование списка CharacterDto -> списка Character
    fun mapToCharacterList(dtoList: List<CharacterDto>): List<Character> {
        return dtoList.map { mapToCharacter(it) }
    }
}