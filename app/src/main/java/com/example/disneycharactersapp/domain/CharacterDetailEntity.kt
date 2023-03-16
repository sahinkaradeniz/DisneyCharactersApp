package com.example.disneycharactersapp.domain

data class CharacterDetailEntity(
    var Id: Int,
    var films:Products,
    var shortFilms:Products,
    var tvShows:Products,
    var videoGames:Products ,
    var allies: List<String> ,
    var enemies: List<String>,
    var name: String,
    var imageUrl: String,
)