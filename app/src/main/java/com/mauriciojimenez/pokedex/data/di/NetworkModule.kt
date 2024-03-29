package com.mauriciojimenez.pokedex.data.di

import com.mauriciojimenez.pokedex.data.remote.network.PokemonApiClient
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
object NetworkModule {
    private const val URL = "https://pokeapi.co/api/v2/"

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
    @Singleton
    @Provides
    fun providerPokemonRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .client(provideHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonApiClient(retrofit: Retrofit): PokemonApiClient {
        return retrofit.create(PokemonApiClient::class.java)
    }
}