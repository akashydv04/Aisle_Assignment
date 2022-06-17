package com.example.aisleassignment.repository.noteRepository

import android.util.Log
import com.example.aisleassignment.data.repository.HomeRepository
import com.example.aisleassignment.data.response.NotesResponse
import com.example.aisleassignment.network.AisleModule.AisleService

class HomeRepositoryImpl(val aisleService: AisleService):HomeRepository {

    override suspend fun getNotes(): NotesResponse? {
        return try {
            val response = aisleService.getNotes()
            if (response.isSuccessful){
                response.body()
            }
            else{
                null
            }
        }
        catch (e: Exception){
            Log.d("asdfgh", "getNotes: ${e.message}")
            null
        }
    }
}