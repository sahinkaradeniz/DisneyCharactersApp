package com.example.disneycharactersapp.di.source

import com.example.disneycharactersapp.data.source.RemoteDataSource
import com.example.disneycharactersapp.data.source.RemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDisneyRemoteSource(remoteDataSourceImp: RemoteDataSourceImp): RemoteDataSource
}