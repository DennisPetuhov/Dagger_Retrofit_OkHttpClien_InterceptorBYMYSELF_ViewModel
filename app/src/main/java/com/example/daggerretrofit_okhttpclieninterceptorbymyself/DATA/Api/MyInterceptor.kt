package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class  MyInterceptor @Inject constructor(var pref: SharedPreferences) : Interceptor {






    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        lateinit var newRequest: Request
        println(request.url().toString()+"********************")
        println(request.url().host().toString()+"HOST********************")
        if ((request.url().toString().contentEquals("https://jwt-springsecurity.herokuapp.com/api/auth/signin", true) ||
                    request.url().toString()
                        .contentEquals("https://jwt-springsecurity.herokuapp.com/api/auth/signup",true)
                    )
        ) {
            newRequest = requestBuilder.build()
        } else{
            newRequest = requestBuilder
                .header("Authorisation", "Bearer ${pref.getString("EDIT_TEXT_KEY","")}")
                .build()
            println(newRequest.url())
            println(newRequest.header("Authorisation"))

        }
        return chain.proceed(newRequest)
    }
}