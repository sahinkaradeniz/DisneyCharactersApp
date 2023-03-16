package com.example.disneycharactersapp.ui.home

import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import com.example.disneycharactersapp.domain.mapper.allcharacter.DisneyCharacterListMapper
import javax.inject.Inject

class CharactersHomeUiMapper @Inject constructor() :DisneyCharacterListMapper<DisneyCharactersEntity,HomeUiData>{
    override fun map(input: List<DisneyCharactersEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(
                it.Id,it.name,it.imageUrl
            )
        } ?: emptyList()
    }
}