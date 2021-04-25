package com.example.jetpackmasterclassdogs.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackmasterclassdogs.model.DogBreed

class DetailViewModel: ViewModel() {
    val dogLiveData = MutableLiveData<DogBreed>()


    fun fetch(){
        val dog =  DogBreed(
            "3",
            dogBreed = "rotweiler",
            lifeSpan = "16 years",
            breedGroup = "breedgroup",
            breedFor = "temperman",
            temperament = "ok",
            imageUrl = ""
        )

        dogLiveData.value = dog
    }
}