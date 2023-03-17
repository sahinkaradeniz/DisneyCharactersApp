package com.example.disneycharactersapp.ui.home

import com.example.disneycharactersapp.data.dto.filtercharacter.FilterData
import com.example.disneycharactersapp.domain.mapper.allcharacter.DisneyCharacterListMapper
import javax.inject.Inject

class SearchHomeUiMapper @Inject
constructor() :DisneyCharacterListMapper<FilterData,HomeUiData>{
    override fun map(input: List<FilterData>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(
                it._id,it.name,it.imageUrl
            )
        } ?: emptyList()
    }
}