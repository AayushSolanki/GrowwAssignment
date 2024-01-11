package com.example.growwassignment.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.growwassignment.repository.CharacterRepository

class MainViewModelFactory (private  val  characterRepository: CharacterRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(characterRepository) as T
    }


}