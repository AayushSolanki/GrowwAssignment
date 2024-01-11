package com.example.growwassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.growwassignment.apiInterface.ApiService
import com.example.growwassignment.apiInterface.RetrofitHelper
import com.example.growwassignment.model.CharacterModel
import com.example.growwassignment.repository.CharacterRepository
import com.example.growwassignment.viewmodels.MainViewModel
import com.example.growwassignment.viewmodels.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

     lateinit var  mainViewModel: MainViewModel
//     lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        bindingUtil=DataBindingUtil.setContentView(this,R.layout.activity_main)
bindingUtil=DataBindingUtil.setContentView<>(this,R.layout.activity_main)
        val gridView=findViewById<GridView>(R.id.gridView)
        val adapter = ArrayAdapter<CharacterModel>(this, R.layout.item)
       binding.gridView.adapter = adapter

        val characterService = RetrofitHelper.getInstance().create(ApiService::class.java)

        val characterRepository = CharacterRepository(characterService)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(characterRepository)).get(MainViewModel::class.java)

        mainViewModel.character.observe(this, Observer {
       adapter.clear()
            val chracterObj = CharacterModel(it.name.toString(),it.gender.toString())

        adapter.addAll(chracterObj)
       adapter.notifyDataSetChanged()
        })



    }
}