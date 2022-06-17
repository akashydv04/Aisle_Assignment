package com.example.aisleassignment.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisleassignment.data.repository.LoginRepository
import com.example.aisleassignment.data.request.OtpRequest
import com.example.aisleassignment.data.response.OtpResponse
import kotlinx.coroutines.launch

class PhoneNumberViewModel(private val repository: LoginRepository): ViewModel() {

    var sendOtpResponse: MutableLiveData<OtpResponse> = MutableLiveData()

    fun sendOTP(otpRequest: OtpRequest) {
        viewModelScope.launch{
            val response = repository.getOTP(otpRequest)

            if (response != null){
                sendOtpResponse.postValue(response)
            }

        }
    }

}