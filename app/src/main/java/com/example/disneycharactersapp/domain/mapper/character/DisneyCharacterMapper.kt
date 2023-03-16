package com.example.disneycharactersapp.domain.mapper.character

interface DisneyCharacterMapper<I,O>{
    fun map(input :I?):O
}