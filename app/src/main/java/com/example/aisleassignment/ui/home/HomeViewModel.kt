package com.example.aisleassignment.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisleassignment.data.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {
    fun getNotes() {
        viewModelScope.launch {
            val response = homeRepository.getNotes()
            Log.d("asdfghjk", "getNotes: $response")
        }
    }

}