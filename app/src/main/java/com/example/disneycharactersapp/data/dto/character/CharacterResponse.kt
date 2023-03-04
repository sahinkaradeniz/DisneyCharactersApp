package com.example.disneycharactersapp.data.dto.character

import com.google.gson.annotations.SerializedName


data class CharacterResponse (

    @SerializedName("_id"             ) var Id              : Int?              = null,
    @SerializedName("films"           ) var films           : List<String> = arrayListOf(),
    @SerializedName("shortFilms"      ) var shortFilms      : List<String> = arrayListOf(),
    @SerializedName("tvShows"         ) var tvShows         : List<String> = arrayListOf(),
    @SerializedName("videoGames"      ) var videoGames      : List<String> = arrayListOf(),
    @SerializedName("parkAttractions" ) var parkAttractions : List<String> = arrayListOf(),
    @SerializedName("allies"          ) var allies          : List<String> = arrayListOf(),
    @SerializedName("enemies"         ) var enemies         : List<String> = arrayListOf(),
    @SerializedName("name"            ) var name            : String?           = null,
    @SerializedName("imageUrl"        ) var imageUrl        : String?           = null,
    @SerializedName("url"             ) var url             : String?           = null

)