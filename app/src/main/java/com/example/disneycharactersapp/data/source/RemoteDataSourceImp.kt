package com.example.disneycharactersapp.data.source

import android.util.Log
import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.data.api.DisneyCharactersApi
import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.data.dto.filtercharacter.FilterData
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor (private val disneyCharactersApi: DisneyCharactersApi):RemoteDataSource {
    val TAG =" Remote Data Source Impl"
    override suspend fun getAllDisneyCharacters(): NetworkResponse<List<CharacterResponse>> =
       try {
            val response=disneyCharactersApi.getAllCharacters()
            NetworkResponse.Success(response.data)
        }catch (e:Exception){
           Log.e(TAG,e.toString())
            NetworkResponse.Error(e)
        }


    override suspend fun getDisneyCharacter(id: Int): NetworkResponse<CharacterResponse> =
        try {
            val response=disneyCharactersApi.getCharacter(id)
            NetworkResponse.Success(response)
        }catch (e:Exception){
            Log.e(TAG,e.toString())
            NetworkResponse.Error(e)
        }


    override suspend fun searchDisneyCharacter(name: String): NetworkResponse<List<FilterData>> =
       try {
           val response =disneyCharactersApi.filterCharacter(name)
           NetworkResponse.Success(response.data)
       }catch (e:Exception){
           Log.e(TAG,e.toString())
           NetworkResponse.Error(e)
       }

}