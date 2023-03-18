package com.example.disneycharactersapp.domain.mapper.allcharacter

import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import javax.inject.Inject

class DisneyCharacterDomainListMapperImp @Inject constructor() :
    DisneyCharacterListMapper<CharacterResponse, DisneyCharactersEntity> {
    override fun map(input: List<CharacterResponse>?): List<DisneyCharactersEntity> {
        return input?.map {
            DisneyCharactersEntity(
                Id = it.Id,
                imageUrl = it.imageUrl,
                name = it.name,
            )
        } ?: emptyList()
    }
}