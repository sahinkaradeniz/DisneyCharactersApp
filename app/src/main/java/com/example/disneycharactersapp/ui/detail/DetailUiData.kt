package com.example.disneycharactersapp.ui.detail

import com.example.disneycharactersapp.domain.*

data class DetailUiData(
    var Id: Int?=null,
    var films:Products?,
    var shortFilms:Products?,
    var tvShows:Products?,
    var videoGames:Products?,
    var name: String?=null,
    var imageUrl: String?=null,
    )