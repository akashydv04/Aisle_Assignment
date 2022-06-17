package com.example.aisleassignment.ui.verifyOtp

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisleassignment.data.repository.LoginRepository
import com.example.aisleassignment.data.request.VerifyOtpRequest
import com.example.aisleassignment.data.response.VerifyOtpResponse
import kotlinx.coroutines.launch

class VerifyOtpViewModel(private val repository: LoginRepository): ViewModel() {

    val verifyOtpResponse: MutableLiveData<VerifyOtpResponse> = MutableLiveData()

    private val timerText  = MutableLiveData<String>()
    private var countDownTimer: CountDownTimer? = null

    companion object{
        private const val OTP_WAIT_DURATION = 60000L
        private const val COUNTDOWN_INTERVAL = 1000L
    }

    fun setCountDownTimer(){
        countDownTimer = object : CountDownTimer(OTP_WAIT_DURATION, COUNTDOWN_INTERVAL){
            var count = 59
            override fun onTick(p0: Long) {
                timerText.postValue(getFormattedDigit(count--))
            }

            override fun onFinish() {
                timerText.postValue(getFormattedDigit(0))
            }

        }.start()
    }

    fun getTimerText(): MutableLiveData<String>{
        return timerText
    }

    fun getFormattedDigit(number: Int):String{
        return if (number<=9)"0$number" else number.toString()
    }

    fun verifyOtp(verifyOtpRequest: VerifyOtpRequest) {
        viewModelScope.launch {
            val response = repository.verifyOTP(verifyOtpRequest)
            verifyOtpResponse.postValue(response)
        }
    }
}