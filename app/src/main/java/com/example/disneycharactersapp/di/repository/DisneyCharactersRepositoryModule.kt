package com.example.disneycharactersapp.di.repository

import com.example.disneycharactersapp.data.repository.DisneyRepository
import com.example.disneycharactersapp.data.repository.DisneyRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DisneyCharactersRepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindDisneyCharactersRepository(disneyRepositoryImp: DisneyRepositoryImp):DisneyRepository
}