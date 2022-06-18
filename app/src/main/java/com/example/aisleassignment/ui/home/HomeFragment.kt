package com.example.aisleassignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aisleassignment.databinding.HomeFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNotes()

        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.notesResponse.observe(viewLifecycleOwner){
            if (it.invites.profiles.isEmpty().not()){
                val name = it.invites.profiles[0].general_information.first_name
                val age = it.invites.profiles[0].general_information.age
                binding.nameAgeTxt.text = "$name, $age"
                Glide.with(this).load(it.invites.profiles[0].photos[0].photo).into(binding.image1)
            }
            if (it.likes.profiles.isEmpty().not() && it.likes.profiles.size >=2){
                binding.nameTxt.text = it.likes.profiles[0].first_name
                binding.nameTxt1.text = it.likes.profiles[1].first_name
                Glide.with(this).load(it.likes.profiles[0].avatar).into(binding.image2)
                Glide.with(this).load(it.likes.profiles[1].avatar).into(binding.image3)

            }
        }
    }
}