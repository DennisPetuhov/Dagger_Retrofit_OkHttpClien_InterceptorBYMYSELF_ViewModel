package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA

import android.content.SharedPreferences
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.CommentApiState
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

    suspend fun signUp(sigUpForm: SignUpForm) = api.signUp(sigUpForm)

    suspend fun signIn(signInForm: SignInForm): Flow<CommentApiState<ResponseSignIn>> {
        return flow {
            val response = api.signIn(signInForm)
            emit(CommentApiState.success(response))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getInfo(): Response<String>? =
        fromPreferences()?.let { api.helloadmin2("Bearer $it") }


    fun toPreferences(token: String?): Unit {
        val editor = pref.edit()
        editor.putString("EDIT_TEXT_KEY", token).apply()
    }

    fun fromPreferences(): String? {
        return pref.getString("EDIT_TEXT_KEY", "")
    }
}