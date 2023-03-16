package com.example.disneycharactersapp.di.network

import com.example.disneycharactersapp.data.api.DisneyCharactersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object DisneyModule {

    @Provides
    @ViewModelScoped
    fun provideDisneyApi():DisneyCharactersApi{
        return Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DisneyCharactersApi::class.java)
    }
}