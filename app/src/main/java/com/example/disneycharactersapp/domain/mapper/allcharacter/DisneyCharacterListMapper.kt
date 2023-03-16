package com.example.disneycharactersapp.domain.mapper.allcharacter

import com.example.disneycharactersapp.domain.mapper.character.DisneyCharacterMapper

interface DisneyCharacterListMapper<I,O> : DisneyCharacterMapper<List<I>, List<O>>