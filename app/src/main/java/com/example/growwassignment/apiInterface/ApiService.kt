package com.example.growwassignment.apiInterface

import com.example.growwassignment.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("people/")
    suspend fun getCharacters():Response <CharacterModel>

}
