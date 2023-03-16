package com.example.disneycharactersapp.domain.usecase.searchcharacter

import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import kotlinx.coroutines.flow.Flow

interface GetSearchCharacterUseCase {
    operator fun invoke(nameText:String):Flow<NetworkResponse<List<DisneyCharactersEntity>>>
}