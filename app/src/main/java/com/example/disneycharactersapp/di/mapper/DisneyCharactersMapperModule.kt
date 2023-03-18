package com.example.disneycharactersapp.di.mapper

import com.example.disneycharactersapp.data.dto.character.CharacterResponse
import com.example.disneycharactersapp.data.dto.filtercharacter.FilterData
import com.example.disneycharactersapp.domain.CharacterDetailEntity
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import com.example.disneycharactersapp.domain.mapper.*
import com.example.disneycharactersapp.domain.mapper.allcharacter.DisneyCharacterDomainListMapperImp
import com.example.disneycharactersapp.domain.mapper.allcharacter.DisneyCharacterListMapper
import com.example.disneycharactersapp.domain.mapper.character.CharacterDomainMapperImpl
import com.example.disneycharactersapp.domain.mapper.character.DisneyCharacterMapper
import com.example.disneycharactersapp.domain.mapper.search.SearchCharacterDomainListMapperImp
import com.example.disneycharactersapp.ui.detail.CharacterDetailUiMapper
import com.example.disneycharactersapp.ui.detail.DetailUiData
import com.example.disneycharactersapp.ui.home.CharactersHomeUiMapper
import com.example.disneycharactersapp.ui.home.HomeUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DisneyCharactersMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun disneyMapper(disneyCharacterListMapperImp: DisneyCharacterDomainListMapperImp): DisneyCharacterListMapper<CharacterResponse, DisneyCharactersEntity>

    @Binds
    @ViewModelScoped
    abstract fun disneyCharacterMapper(characterDomainMapperImp: CharacterDomainMapperImpl): DisneyCharacterMapper<CharacterResponse, CharacterDetailEntity>


    @Binds
    @ViewModelScoped
    abstract fun disneySearchCharacterMapper(searchCharacterDomainListMapperImp: SearchCharacterDomainListMapperImp): DisneyCharacterListMapper<FilterData, DisneyCharactersEntity>

    @Binds
    @ViewModelScoped
    abstract fun disneyHomeUiMapper(charactersHomeUiMapper: CharactersHomeUiMapper):DisneyCharacterListMapper<DisneyCharactersEntity,HomeUiData>

    @Binds
    @ViewModelScoped
    abstract fun disneyDetailUiMapper(characterDetailUiMapper: CharacterDetailUiMapper ):DisneyCharacterMapper<CharacterDetailEntity,DetailUiData>
}