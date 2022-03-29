package com.teamb.moviespoc.di
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.network.ResultsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor()).build()

    @Singleton
    @Provides
    fun provideResultsApiClient(retrofit: Retrofit): ResultsApiClient {
        return retrofit.create(ResultsApiClient::class.java)
    }
}