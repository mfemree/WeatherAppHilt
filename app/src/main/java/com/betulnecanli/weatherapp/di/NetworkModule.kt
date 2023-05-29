package com.betulnecanli.weatherapp.di

import com.betulnecanli.weatherapp.network.WeatherService
import com.betulnecanli.weatherapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {              //  bu modulu singleton olarak tanimladik. uygulama ayakta oldugu surece bunlar da ayakta olsun diye boyle yaptik.

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {           // loggatta attigimiz istekleri gormemizi sagliyor. onun icn yazdik
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY   // body'i goster diyoruz.
                                                        // body icinde de request, response ve url imiz vardi
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)                                    // bizim loglama islemizi yapan kisim
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit): WeatherService { // weatherService'mizi provide edecek methodumuzu yazdik,
        return retrofit.create(WeatherService::class.java)
    }
}