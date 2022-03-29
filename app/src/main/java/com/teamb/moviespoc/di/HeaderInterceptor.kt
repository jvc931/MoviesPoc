package com.teamb.moviespoc.di
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
            "api_key",
            "2c6ad4a84f72acef01de56e51a16573e"
        ).build()
        return chain.proceed(request)
    }
}