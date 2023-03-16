package com.example.disneycharactersapp.domain.mapper.search

import com.example.disneycharactersapp.domain.mapper.character.DisneyCharacterMapper

interface DisneySearchCharacterListMapper<I,O> :DisneyCharacterMapper<List<I>, List<O>>