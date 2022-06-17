package com.example.aisleassignment.network

import android.util.Log
import com.example.aisleassignment.network.AisleModule.AisleService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.EventListener
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException
import java.util.concurrent.TimeUnit


object AisleServiceFactory {

    fun makeAisleService(): AisleService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://testa2.aisle.co/V1/")
            .client(makeOkHttpClient(makeLoggingInterceptor()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(makeGson()))
            .build()
        return retrofit.create(AisleService::class.java)
    }

    fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()

                // Customize the request
                val request = original.newBuilder()
                request.header("Content-Type", "application/x-www-form-urlencoded")

                var response: Response?
                try {
                    response = chain.proceed(request.build())
                    // Customize or return the response
                    response
                } catch (e: ConnectException) {
                    Log.e("RETROFIT", "ERROR : " + e.localizedMessage)
                    chain.proceed(original)
                } catch (e: SocketException) {
                    Log.e("RETROFIT", "ERROR : " + e.localizedMessage)
                    chain.proceed(original)
                } catch (e: IOException) {
                    Log.e("RETROFIT", "ERROR : " + e.localizedMessage)
                    chain.proceed(original)
                } catch (e: Exception) {
                    Log.e("RETROFIT", "ERROR : " + e.localizedMessage)
                    chain.proceed(original)
                }
            }
            .eventListener(object : EventListener() {

            })
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(RetrofitHeaderInterceptor())
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    fun makeGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level =
            HttpLoggingInterceptor.Level.BODY
        return logging
    }
}