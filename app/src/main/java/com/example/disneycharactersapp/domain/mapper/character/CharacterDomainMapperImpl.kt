package com.example.disneycharactersapp.domain.mapper.character

import android.annotation.SuppressLint
import android.content.Context
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.domain.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CharacterDomainMapperImpl @Inject constructor(@ApplicationContext val context: Context) :
    DisneyCharacterMapper<CharacterResponse, CharacterDetailEntity> {
    @SuppressLint("ResourceType")
    override fun map(input: CharacterResponse?): CharacterDetailEntity {
        return CharacterDetailEntity(
            name = input?.name.orEmpty(),
            imageUrl = input?.imageUrl.orEmpty(),
            Id = input?.Id ?: 0,
            films = Products(
                ProductTypes.FILM,
                context.getString(R.string.films),
                input?.films ?: emptyList()
            ),
            tvShows = Products(
                ProductTypes.TV_SHOW,
                context.getString(R.string.tvShows),
                input?.tvShows ?: emptyList()
            ),
            shortFilms = Products(
                ProductTypes.SHORT_FILM,
                context.getString(R.string.shortfilms),
                input?.shortFilms ?: emptyList()
            ),
            videoGames = Products(
                ProductTypes.VIDEO_GAME,
                context.getString(R.string.videoGames),
                input?.videoGames ?: emptyList()
            ),
            allies = input?.allies ?: emptyList(),
            enemies = input?.enemies ?: emptyList()
        )
    }

}
