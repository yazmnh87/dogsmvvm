package com.example.jetpackmasterclassdogs.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackmasterclassdogs.model.DogBreed
import com.example.jetpackmasterclassdogs.model.DogDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application): BaseViewModel(application) {
    val dogLiveData = MutableLiveData<DogBreed>()


    fun fetch(uuid: Int){
        launch{
        val dog = DogDatabase(getApplication()).dogDao().getDog(uuid)
        dogLiveData.value = dog
        }
    }
}