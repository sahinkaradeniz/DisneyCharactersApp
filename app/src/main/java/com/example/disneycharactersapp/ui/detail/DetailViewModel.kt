package com.example.disneycharactersapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.data.NetworkResponse
import com.example.disneycharactersapp.domain.CharacterDetailEntity
import com.example.disneycharactersapp.domain.mapper.character.DisneyCharacterMapper
import com.example.disneycharactersapp.domain.usecase.getcharacter.GetDisneyCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDisneyCharacterUseCase: GetDisneyCharacterUseCase,
    private val disneyCharacterMapper: DisneyCharacterMapper<CharacterDetailEntity,DetailUiData>
): ViewModel() {
    private var _detailUiState=MutableLiveData<DetailUiState>()
    val detailUiState:LiveData<DetailUiState> get() = _detailUiState

    fun getDisneyCharacter(id:Int){
        getDisneyCharacterUseCase(id = id).onEach {
            when(it){
                is NetworkResponse.Error ->{
                    _detailUiState.postValue(DetailUiState.Error(R.string.eror))
                }
                is NetworkResponse.Success ->{
                    _detailUiState.postValue(DetailUiState.Success(disneyCharacterMapper.map(it.result)))
                }
                is NetworkResponse.Loading ->{
                    _detailUiState.postValue(DetailUiState.Loading)
                }
            }

        }.launchIn(viewModelScope)

    }

}