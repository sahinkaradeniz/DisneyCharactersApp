package com.example.disneycharactersapp.domain.usecase.getcharacter

import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.domain.CharacterDetailEntity
import kotlinx.coroutines.flow.Flow

interface GetDisneyCharacterUseCase {
    operator fun invoke(id:Int): Flow<NetworkResponse<CharacterDetailEntity>>
}