package com.example.disneycharactersapp.domain.usecase.searchcharacter

import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.data.dto.filtercharacter.FilterData
import com.example.disneycharactersapp.data.repository.DisneyRepository
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import com.example.disneycharactersapp.domain.mapper.allcharacter.DisneyCharacterListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSearchCharacterUseCaseImpl @Inject constructor(
    private val disneyRepository: DisneyRepository,
    private val searchCharacterListMapper: DisneyCharacterListMapper<FilterData, DisneyCharactersEntity>
) : GetSearchCharacterUseCase {
    override fun invoke(nameText: String): Flow<NetworkResponse<List<DisneyCharactersEntity>>> =
        flow {
            emit(NetworkResponse.Loading)
            when (val response = disneyRepository.searchDisneyCharacter(nameText)) {
                is NetworkResponse.Error -> emit(response)
                is NetworkResponse.Loading -> Unit
                is NetworkResponse.Success -> emit(
                    NetworkResponse.Success(searchCharacterListMapper.map(response.result))
                )
            }
        }
}