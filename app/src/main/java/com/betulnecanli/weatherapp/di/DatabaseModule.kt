package com.betulnecanli.weatherapp.di

import android.content.Context
import com.betulnecanli.weatherapp.data.local.WeatherDB
import com.betulnecanli.weatherapp.data.local.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// iki object Modulu de SingletonComponent olmasina ragmen iki ayri class da yaptik. daha best practise olsun diye. ama ayni class'da da yapabilirdik tabi..

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideWeatherDB(@ApplicationContext context: Context): WeatherDB {  // weatherDB icinde context kullandigi icin boyle yaptik
        return WeatherDB.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideWeatherDao(weatherDB: WeatherDB): WeatherDao {
        return weatherDB.weatherDao()
    }
}