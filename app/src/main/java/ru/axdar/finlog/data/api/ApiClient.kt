package ru.axdar.finlog.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.axdar.finlog.BuildConfig
import java.util.concurrent.TimeUnit

/** Created on 06.12.2020. */
class ApiClient {

    private val HEADER_NAME: String = "X-CMC_PRO_API_KEY"
    private val loggingInterceptor = HttpLoggingInterceptor()

    private fun okHttpClient(): OkHttpClient {

        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(Interceptor {
                val original: Request = it.request()
                val request: Request = original.newBuilder()
                    .header("Accept", "application/json")
                    .header(HEADER_NAME, BuildConfig.API_KEY)
                    .build()
                return@Interceptor it.proceed(request)
            })
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    fun makeService(): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.COINMARKET_URL)
            .client(okHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }
}