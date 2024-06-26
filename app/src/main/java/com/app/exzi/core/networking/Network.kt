package com.app.exzi.core.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManager {
    fun <T> create(serviceClass: Class<T>): T = getClient().create(serviceClass)

    // TODO remove hardcoded base url and must be in BuildConfig.
    private fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://socket.exzi.com") // its could be in BuildConfig.
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .headerInterceptor()
                    .apply {
                        logInterceptor()
                    }
                    .readTimeout(120, TimeUnit.SECONDS)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .build(),
            )
            .build()
    }

    private fun OkHttpClient.Builder.headerInterceptor(): OkHttpClient.Builder {
        return this.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder
                .method(original.method, original.body)
                .header("Content-Type", "application/json")
                .build()
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    private fun OkHttpClient.Builder.logInterceptor(): OkHttpClient.Builder {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return this.addInterceptor(interceptor)
    }
}
