package com.example.disneycharactersapp.domain.usecase.getallcharacter

import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.data.repository.DisneyRepository
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import com.example.disneycharactersapp.domain.mapper.allcharacter.DisneyCharacterListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDisneyUseCaseImpl @Inject constructor(
    private val disneyRepository: DisneyRepository,
    private val disneyCharacterResponseListMapper: DisneyCharacterListMapper<CharacterResponse, DisneyCharactersEntity>,
) : GetDisneyUseCase {
    override fun invoke(): Flow<NetworkResponse<List<DisneyCharactersEntity>>> = flow {
        emit(NetworkResponse.Loading)
        when (val response = disneyRepository.getAllDisneyCharacters()) {
            is NetworkResponse.Error -> emit(response)
            is NetworkResponse.Loading -> Unit
            is NetworkResponse.Success -> emit(
                NetworkResponse.Success(
                    disneyCharacterResponseListMapper. map(
                        response.result
                    )
                )
            )
        }
    }
}