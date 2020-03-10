package com.geovanni.banks.bussiness.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServicesRetrofitManager {

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(120, TimeUnit.SECONDS)
        .connectTimeout(120, TimeUnit.SECONDS)
        .build()

    val retrofitAPI: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(ServicesConstants.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    companion object {
        @get:Synchronized
        var instance: ServicesRetrofitManager? = null
            get() {
                if (field == null) {
                    field = ServicesRetrofitManager()
                }
                return field
            }
            private set
    }
}