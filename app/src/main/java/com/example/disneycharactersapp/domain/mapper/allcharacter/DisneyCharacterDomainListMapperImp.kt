package com.example.disneycharactersapp.domain.mapper.allcharacter

import com.example.disneycharactersapp.data.dto.allcharacter.CharacterData
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import javax.inject.Inject

class DisneyCharacterDomainListMapperImp @Inject constructor() :
    DisneyCharacterListMapper<CharacterData, DisneyCharactersEntity> {
    override fun map(input: List<CharacterData>?): List<DisneyCharactersEntity> {
        return input?.map {
            DisneyCharactersEntity(
                Id = it.Id,
                imageUrl = it.imageUrl,
                name = it.name,
            )
        } ?: emptyList()
    }
}