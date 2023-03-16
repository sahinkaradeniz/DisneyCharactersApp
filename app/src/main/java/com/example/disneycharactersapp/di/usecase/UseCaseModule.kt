package com.example.disneycharactersapp.di.usecase

import com.example.disneycharactersapp.domain.usecase.getallcharacter.GetDisneyUseCase
import com.example.disneycharactersapp.domain.usecase.getallcharacter.GetDisneyUseCaseImpl
import com.example.disneycharactersapp.domain.usecase.getcharacter.GetDisneyCharacterUseCase
import com.example.disneycharactersapp.domain.usecase.getcharacter.GetDisneyCharacterUseCaseImpl
import com.example.disneycharactersapp.domain.usecase.searchcharacter.GetSearchCharacterUseCase
import com.example.disneycharactersapp.domain.usecase.searchcharacter.GetSearchCharacterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetDisneyCharacters(getDisneyUseCaseImpl: GetDisneyUseCaseImpl):GetDisneyUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetDisneyCharacter(getDisneyCharacterUseCaseImpl: GetDisneyCharacterUseCaseImpl):GetDisneyCharacterUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetSearchCharacters(getSearchCharacterUseCaseImpl: GetSearchCharacterUseCaseImpl):GetSearchCharacterUseCase
}
