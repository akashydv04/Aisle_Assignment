package com.example.aisleassignment.network

import com.example.aisleassignment.prefs.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response

class RetrofitHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val token = PreferenceHelper.getString("auth_token")
        proceed(
            request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    token?:""
                )
                .build()
        )
    }
}