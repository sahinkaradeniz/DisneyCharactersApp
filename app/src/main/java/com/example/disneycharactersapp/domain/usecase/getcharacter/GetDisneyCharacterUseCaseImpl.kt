package com.example.disneycharactersapp.domain.usecase.getcharacter

import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.data.repository.DisneyRepository
import com.example.disneycharactersapp.domain.CharacterDetailEntity
import com.example.disneycharactersapp.domain.mapper.character.DisneyCharacterMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDisneyCharacterUseCaseImpl @Inject constructor(
    private val disneyRepository: DisneyRepository,
    private val characterResponseDomainMapper: DisneyCharacterMapper<CharacterResponse, CharacterDetailEntity>
): GetDisneyCharacterUseCase {
    override fun invoke(id:Int): Flow<NetworkResponse<CharacterDetailEntity>> =  flow {
        emit(NetworkResponse.Loading)
        when(val response=disneyRepository.getDisneyCharacter(id)){
            is NetworkResponse.Error -> emit(response)
            is NetworkResponse.Loading -> Unit
            is NetworkResponse.Success -> emit(
                NetworkResponse.Success(characterResponseDomainMapper.map(response.result))
            )
        }
    }
}