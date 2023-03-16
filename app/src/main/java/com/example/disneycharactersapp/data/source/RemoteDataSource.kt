package com.example.disneycharactersapp.data.source

import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.data.dto.allcharacter.CharacterData
import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.data.dto.filtercharacter.FilterData

 interface RemoteDataSource {
    suspend fun getAllDisneyCharacters(): NetworkResponse<List<CharacterData>>
    suspend fun getDisneyCharacter(id:Int): NetworkResponse<CharacterResponse>
    suspend fun searchDisneyCharacter(name:String): NetworkResponse<List<FilterData>>
}