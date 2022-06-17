package com.example.aisleassignment.data.repository

import com.example.aisleassignment.data.response.NotesResponse

interface HomeRepository {
    suspend fun getNotes(): NotesResponse?
}