package com.example.jetpackmasterclassdogs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.jetpackmasterclassdogs.R
import com.example.jetpackmasterclassdogs.util.getProgressDrawable
import com.example.jetpackmasterclassdogs.util.loadImage
import com.example.jetpackmasterclassdogs.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var dogUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            dogUuid = DetailFragmentArgs.fromBundle(it).dogUuid
        }
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch(dogUuid)

            observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.dogLiveData.observe(this, Observer { dog ->
            dog?.let {
                dogName.text = dog.dogBreed
                dogPurpose.text = dog.breedFor
                dogTemperment.text = dog.temperament
                dogLifeSpan.text = dog.lifeSpan
                context?.let {
                    dogImage.loadImage(dog.imageUrl, getProgressDrawable(it))
                }
            }
        })
    }


}