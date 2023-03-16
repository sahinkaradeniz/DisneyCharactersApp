package com.example.disneycharactersapp.data.dto.allcharacter

import com.google.gson.annotations.SerializedName

data class DisneyResponse(
    @SerializedName("data"       ) var data       : List<CharacterData> = arrayListOf(),
    @SerializedName("count"      ) var count      : Int?            = null,
    @SerializedName("totalPages" ) var totalPages : Int?            = null,
    @SerializedName("nextPage"   ) var nextPage   : String?         = null
)