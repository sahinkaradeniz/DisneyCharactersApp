package com.example.disneycharactersapp.domain.usecase.getallcharacter

import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import kotlinx.coroutines.flow.Flow

interface GetDisneyUseCase {
    operator fun invoke(): Flow<NetworkResponse<List<DisneyCharactersEntity>>>
}