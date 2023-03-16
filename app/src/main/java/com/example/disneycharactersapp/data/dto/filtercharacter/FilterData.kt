package com.example.disneycharactersapp.data.dto.filtercharacter


data class FilterData(

    var _id: Int,
    var films: List<String>,
    var shortFilms: List<String>,
    var tvShows: List<String>,
    var videoGames: List<String>,
    var parkAttractions: List<String>,
    var allies: List<String>,
    var enemies: List<String>,
    var name: String,
    var imageUrl: String,
    var url: String,

    )