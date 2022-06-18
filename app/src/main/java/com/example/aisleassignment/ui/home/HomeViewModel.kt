package com.example.aisleassignment.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisleassignment.data.repository.HomeRepository
import com.example.aisleassignment.data.response.NotesResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {

    val notesResponse: MutableLiveData<NotesResponse> = MutableLiveData()

    fun getNotes() {
        viewModelScope.launch {
            val response = homeRepository.getNotes()
            if (response != null)
                notesResponse.postValue(response)
        }
    }

}