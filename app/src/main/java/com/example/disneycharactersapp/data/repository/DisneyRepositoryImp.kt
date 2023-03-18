package com.example.disneycharactersapp.data.repository

import android.util.Log
import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.data.dto.filtercharacter.FilterData
import com.example.disneycharactersapp.data.source.RemoteDataSource
import com.example.disneycharactersapp.di.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DisneyRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : DisneyRepository {
    val TAG =" Disney Repository Impl"
    override suspend fun getAllDisneyCharacters(): NetworkResponse<List<CharacterResponse>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getAllDisneyCharacters()
            } catch (e: Exception) {
                Log.e(TAG,e.toString())
                NetworkResponse.Error(e)
            }
        }

    override suspend fun getDisneyCharacter(id: Int): NetworkResponse<CharacterResponse> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getDisneyCharacter(id)
            } catch (e: Exception) {
                Log.e(TAG,e.toString())
                NetworkResponse.Error(e)
            }
        }

    override suspend fun searchDisneyCharacter(name: String): NetworkResponse<List<FilterData>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.searchDisneyCharacter(name)
            } catch (e: Exception) {
                Log.e(TAG,e.toString())
                NetworkResponse.Error(e)
            }
        }
}