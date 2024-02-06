package com.thoughtctlapp.di

import com.thoughtctlapp.constant.Constant.BASE_URL
import com.thoughtctlapp.api.ImgApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(httpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit) : ImgApiService {
        return retrofit.create(ImgApiService::class.java)
    }

    private fun httpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .addInterceptor(RequestInterceptor())
        return builder.build()
    }
}

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.header("Authorization", "Client-ID 460d7db4c5feea1");
        return chain.proceed(request.build())
    }
}

class LoggingInterceptor : Interceptor {

    private val loggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        loggingInterceptor.intercept(chain)
        val response = chain.proceed(request)
        loggingInterceptor.intercept(chain)
        return response
    }
}