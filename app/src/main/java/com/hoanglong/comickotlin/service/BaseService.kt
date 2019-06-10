package com.hoanglong.comickotlin.service

import android.text.TextUtils
import com.hoanglong.comickotlin.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BaseService {

    companion object {
        fun getService(): IApiService {
            return getRetrofit("").create(IApiService::class.java)
        }

        fun getService(yourDomain: String): IApiService {
            return getRetrofit(yourDomain).create(IApiService::class.java)
        }

        private fun getRetrofit(yourDomain: String?): Retrofit {
            System.setProperty("http.keepAlive", "false")
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
            val retrofit: Retrofit

            retrofit = when {
                yourDomain != null && !TextUtils.isEmpty(yourDomain) -> Retrofit.Builder()
                    .baseUrl(yourDomain)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                else -> Retrofit.Builder()
                    .baseUrl(Constants.URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }

}