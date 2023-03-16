package com.example.disneycharactersapp.ui.detail

import com.example.disneycharactersapp.domain.CharacterDetailEntity
import com.example.disneycharactersapp.domain.mapper.character.DisneyCharacterMapper
import javax.inject.Inject

class CharacterDetailUiMapper @Inject constructor() :DisneyCharacterMapper<CharacterDetailEntity,DetailUiData>{
    override fun map(input: CharacterDetailEntity?): DetailUiData {
        return DetailUiData(
            name = input?.name.orEmpty(),
            imageUrl = input?.imageUrl.orEmpty(),
            Id = input?.Id ?: 0,
            films = input?.films,
            tvShows = input?.tvShows ,
            shortFilms = input?.shortFilms,
            videoGames = input?.videoGames
        )
    }
}