package com.example.disneycharactersapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.domain.DisneyCharactersEntity
import com.example.disneycharactersapp.domain.mapper.allcharacter.DisneyCharacterListMapper
import com.example.disneycharactersapp.domain.usecase.getallcharacter.GetDisneyUseCase
import com.example.disneycharactersapp.domain.usecase.searchcharacter.GetSearchCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSearchCharacterUseCase: GetSearchCharacterUseCase,
    private val disneyCharacterMapper:DisneyCharacterListMapper<DisneyCharactersEntity,HomeUiData>,
    private val getDisneyUseCase:GetDisneyUseCase
) : ViewModel() {

    private val _disneyHomeUiState=MutableLiveData<HomeUiState>()
    val disneyHomeUiState:LiveData<HomeUiState>  get() = _disneyHomeUiState

    fun searchDisneyCharacters(name:String) {
        getSearchCharacterUseCase(nameText = name).onEach {
            when(it){
                is NetworkResponse.Error -> {
                    _disneyHomeUiState.postValue(HomeUiState.Error(R.string.eror))
                }
                NetworkResponse.Loading -> {
                    _disneyHomeUiState.postValue(HomeUiState.Loading)
                }
                is NetworkResponse.Success -> {
                    _disneyHomeUiState.postValue(HomeUiState.Success(disneyCharacterMapper.map(it.result)))
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getDisneyCharacters(){
        getDisneyUseCase().onEach {
            when(it){
                is NetworkResponse.Error ->{
                    _disneyHomeUiState.postValue(HomeUiState.Error(R.string.eror))
                }
                is NetworkResponse.Loading ->{
                    _disneyHomeUiState.postValue(HomeUiState.Loading)
                }
                is NetworkResponse.Success ->{
                    _disneyHomeUiState.postValue(HomeUiState.Success(disneyCharacterMapper.map(it.result)))
                }
            }
        }.launchIn(viewModelScope)
    }
}