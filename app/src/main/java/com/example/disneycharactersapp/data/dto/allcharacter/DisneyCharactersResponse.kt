package com.example.disneycharactersapp.data.dto.allcharacter

import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.google.gson.annotations.SerializedName

data class DisneyCharactersResponse(
    @SerializedName("data"       ) var data       : List<CharacterResponse> = arrayListOf(),
    @SerializedName("count"      ) var count      : Int?            = null,
    @SerializedName("totalPages" ) var totalPages : Int?            = null,
    @SerializedName("nextPage"   ) var nextPage   : String?         = null
)