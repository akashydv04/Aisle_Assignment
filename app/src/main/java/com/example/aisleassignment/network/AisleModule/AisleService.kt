package com.example.aisleassignment.network.AisleModule

import com.example.aisleassignment.data.request.OtpRequest
import com.example.aisleassignment.data.request.VerifyOtpRequest
import com.example.aisleassignment.data.response.NotesResponse
import com.example.aisleassignment.data.response.OtpResponse
import com.example.aisleassignment.data.response.VerifyOtpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AisleService {


    @POST("users/phone_number_login")
    suspend fun sendOTP(@Body request: OtpRequest): Response<OtpResponse>

    @POST("users/verify_otp")
    suspend fun verifyOtp(@Body request: VerifyOtpRequest): Response<VerifyOtpResponse>

    @GET("/users/test_profile_list")
    suspend fun getNotes(): Response<NotesResponse>
}