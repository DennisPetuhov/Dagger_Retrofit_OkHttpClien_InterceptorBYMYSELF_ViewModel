package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.ResponseSignIn
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.ResponseSignUp
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import retrofit2.Response
import retrofit2.http.*

interface MyApi {

    @POST("api/auth/signup")
    suspend fun signUp(@Body body: SignUpForm): String
//    suspend fun signUp1(@Body body: SignUpForm):ResponseSignIn
    //Чтобы сформировать тело запроса для данного метода,
// мы используем аннотацию @Body для передаваемого параметра. Retrofit будет использовать Gson
// для конвертации @Body в JSON.


    @POST("api/auth/signin")
    suspend fun signIn(@Body body: SignInForm): ResponseSignIn

    @GET("hello/admin")
    suspend fun helloUsername(
//        @Header("Authorization")
//        token: String,
//        @Path("name")
//        name: String
    ): String

    @GET("hello/admin")
    suspend fun helloadmin2(@Header("Authorization") token: String): Response<String>


}