package com.example.jetpackmasterclassdogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackmasterclassdogs.model.DogBreed

class ListViewModel: ViewModel(){

    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 = DogBreed(
            "1",
            dogBreed = "corgi",
            lifeSpan = "16 years",
            breedGroup = "breedgroup",
            breedFor = "temperman",
            temperament = "ok",
            imageUrl = ""
        )
        val dog2 = DogBreed(
            "2",
            dogBreed = "lab",
            lifeSpan = "16 years",
            breedGroup = "breedgroup",
            breedFor = "temperman",
            temperament = "ok",
            imageUrl = ""
        )
        val dog3 = DogBreed(
            "3",
            dogBreed = "rotweiler",
            lifeSpan = "16 years",
            breedGroup = "breedgroup",
            breedFor = "temperman",
            temperament = "ok",
            imageUrl = ""
        )
        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false
    }

}