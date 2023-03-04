package com.example.disneycharactersapp.data.dto.filtercharacter

import com.google.gson.annotations.SerializedName


data class FilterResponse (
    @SerializedName("count" ) var count : Int?            = null,
    @SerializedName("data"  ) var data  : ArrayList<FilterData> = arrayListOf()

)