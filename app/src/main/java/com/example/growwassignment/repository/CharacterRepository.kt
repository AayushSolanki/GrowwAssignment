package com.example.growwassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.growwassignment.apiInterface.ApiService
import com.example.growwassignment.model.CharacterModel

class CharacterRepository(private val apiService: ApiService) {

    private val characterLiveData = MutableLiveData<CharacterModel>()

    val character:LiveData<CharacterModel>
        get() = characterLiveData

suspend fun getCharacters() {
    val res = apiService.getCharacters()
    if (res?.body() != null) {
characterLiveData.postValue(res.body())
    }
}
}