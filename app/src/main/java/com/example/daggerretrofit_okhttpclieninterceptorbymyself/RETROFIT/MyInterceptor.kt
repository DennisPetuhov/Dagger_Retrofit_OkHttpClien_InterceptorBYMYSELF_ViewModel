package com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT

import android.content.SharedPreferences
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.App.App
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class  MyInterceptor @Inject constructor(var pref: SharedPreferences) : Interceptor {






    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        lateinit var newRequest: Request
        if ((request.url()
                .equals("https://jwt-springsecurity.herokuapp.com/api/auth/signin") ||
                    request.url()
                        .equals("https://jwt-springsecurity.herokuapp.com/api/auth/signup")
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