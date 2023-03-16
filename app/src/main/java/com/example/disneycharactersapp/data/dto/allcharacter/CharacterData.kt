package com.example.disneycharactersapp.data.dto.allcharacter
import com.google.gson.annotations.SerializedName


data class CharacterData (

    @SerializedName("films"           ) var films           : List<String> ,
    @SerializedName("shortFilms"      ) var shortFilms      : List<String> ,
    @SerializedName("tvShows"         ) var tvShows         : List<String> ,
    @SerializedName("videoGames"      ) var videoGames      : List<String> ,
    @SerializedName("parkAttractions" ) var parkAttractions : List<String> ,
    @SerializedName("allies"          ) var allies          : List<String> ,
    @SerializedName("enemies"         ) var enemies         : List<String>,
    @SerializedName("_id"             ) var Id              : Int,
    @SerializedName("name"            ) var name            : String,
    @SerializedName("imageUrl"        ) var imageUrl        : String,
    @SerializedName("url"             ) var url             : String
)