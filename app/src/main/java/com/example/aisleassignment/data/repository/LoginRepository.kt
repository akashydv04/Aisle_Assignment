package com.example.aisleassignment.data.repository

import com.example.aisleassignment.data.request.OtpRequest
import com.example.aisleassignment.data.request.VerifyOtpRequest
import com.example.aisleassignment.data.response.OtpResponse
import com.example.aisleassignment.data.response.VerifyOtpResponse
import retrofit2.Response

interface LoginRepository {
    suspend fun getOTP(otpRequest: OtpRequest): OtpResponse?
    suspend fun verifyOTP(verifyOtpRequest: VerifyOtpRequest): VerifyOtpResponse?
}