package com.example.growwassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.growwassignment.model.CharacterModel
import com.example.growwassignment.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    init {
            viewModelScope.launch(Dispatchers.IO){
            characterRepository.getCharacters()
        }
    }

    val character:LiveData<CharacterModel>
        get() =characterRepository.character


}