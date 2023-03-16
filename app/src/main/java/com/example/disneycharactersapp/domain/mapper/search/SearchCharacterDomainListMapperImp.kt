package com.example.disneycharactersapp.domain.mapper.search

import com.example.disneycharactersapp.data.dto.filtercharacter.FilterData
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import javax.inject.Inject

class SearchCharacterDomainListMapperImp @Inject constructor():
    DisneySearchCharacterListMapper<FilterData, DisneyCharactersEntity> {

    override fun map(input: List<FilterData>?): List<DisneyCharactersEntity> {
        return input?.map {
            DisneyCharactersEntity(
                Id = it._id,
                name = it.name,
                imageUrl = it.imageUrl
            )
        } ?: emptyList()
    }
}