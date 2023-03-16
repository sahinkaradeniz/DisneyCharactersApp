package com.example.disneycharactersapp.data.api

import com.example.disneycharactersapp.data.dto.allcharacter.DisneyResponse
import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.data.dto.filtercharacter.FilterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DisneyCharactersApi {

    @GET("characters")
    suspend fun getAllCharacters():DisneyResponse

    @GET("characters/{character_number}")
    suspend fun getCharacter(@Path("character_number") characterNumber: Int):CharacterResponse

    @GET("character")
    suspend fun filterCharacter(@Query("name") characterText:String):FilterResponse
}