package com.example.aisleassignment.repository.loginRepository

import com.example.aisleassignment.data.repository.LoginRepository
import com.example.aisleassignment.data.request.OtpRequest
import com.example.aisleassignment.data.request.VerifyOtpRequest
import com.example.aisleassignment.data.response.OtpResponse
import com.example.aisleassignment.data.response.VerifyOtpResponse
import com.example.aisleassignment.network.AisleModule.AisleService

class LoginRepositoryImpl(
    private val aisleService: AisleService
) : LoginRepository {

    override suspend fun getOTP(otpRequest: OtpRequest): OtpResponse? {
        return try {
            val response = aisleService.sendOTP(otpRequest)
            if (response.isSuccessful){
                response.body()
            }
            else{
                null
            }
        }
        catch (e: Exception){
            OtpResponse(false)
        }
    }

    override suspend fun verifyOTP(verifyOtpRequest: VerifyOtpRequest): VerifyOtpResponse? {
        return try {
            val response = aisleService.verifyOtp(verifyOtpRequest)
            if (response.isSuccessful){
                response.body()
            }
            else{
                null
            }
        }
        catch (e: Exception){
            VerifyOtpResponse("")
        }
    }

}