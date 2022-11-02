package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA

import android.content.SharedPreferences
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.MyApi
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.ResponseSignIn
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

import javax.inject.Inject

class Repository @Inject constructor(val pref: SharedPreferences, val api: MyApi) {

    suspend fun signUp(sigUpForm: SignUpForm): Flow<ApiState<String>> {
        return flow {
            val response = api.signUp(sigUpForm)
            emit(ApiState.success(response))
        }.flowOn(Dispatchers.IO)
    }

    //  suspend fun signIn(signInForm: SignInForm) = api.signIn(signInForm)


    suspend fun signIn(signInForm: SignInForm): Flow<ApiState<ResponseSignIn>> {
        return flow {
            val response = api.signIn(signInForm)
            emit(ApiState.success(response))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getInfo(): Response<String>? =
        fromPreferences()?.let { api.helloadmin2("Bearer $it") }


    suspend fun informationRequest(): Flow<ApiState<String>> {
        return flow {
            val response = api.helloUsername()

//                fromPreferences()?.let {
//                api.helloUsername("Bearer $it")
//            }
            emit(ApiState.success(response))
        }.flowOn(Dispatchers.IO)
    }


    fun toPreferences(token: String?) {
        val editor = pref.edit()
        editor.putString("EDIT_TEXT_KEY", token).apply()
    }

    fun fromPreferences(): String? {
        return pref.getString("EDIT_TEXT_KEY", "")
    }

    fun deleteDataFromPreferences(key: String?): Unit {
        val editor = pref.edit()
        return editor.remove(key).apply()
    }
}