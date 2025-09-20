package com.ferdows.pokedex.module

import com.ferdows.pokedex.activity.MainActivity
import com.ferdows.pokedex.network.PokeAPIService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(MainActivity::class)
object NetworkModule {

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @Provides
    fun provideRetrofit(
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providePokeApiService(
        retrofit: Retrofit
    ): PokeAPIService {
        return retrofit.create(PokeAPIService::class.java)
    }
}