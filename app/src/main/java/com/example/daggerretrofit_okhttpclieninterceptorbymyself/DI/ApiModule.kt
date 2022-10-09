package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DI

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT.MyApi
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT.MyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

@Module

class ApiModule {
    @Provides
    fun provideInerceptorClient(myInterceptor:MyInterceptor): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(myInterceptor).build()
    }

    @Provides
    fun provideApi(okHttpClient: OkHttpClient):MyApi{
       val retofin = Retrofit.Builder()
            .baseUrl("https://jwt-springsecurity.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api:MyApi = retofin.create(MyApi::class.java)
        return api
    }

}
