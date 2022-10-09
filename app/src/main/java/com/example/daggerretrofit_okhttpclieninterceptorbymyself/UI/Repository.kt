package com.example.daggerretrofit_okhttpclieninterceptorbymyself.UI

import android.content.SharedPreferences
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT.MyApi
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT.SignInForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT.SignUpForm
import javax.inject.Inject

class Repository @Inject constructor(val pref: SharedPreferences, val api: MyApi) {

    suspend fun signUp(sigUpForm: SignUpForm) = api.signUp(sigUpForm)
    suspend fun signIn(signInForm: SignInForm) = api.signIn(signInForm)
    suspend fun getInfo() = fromPreferences()?.let { api.helloadmin2("Bearer $it") }


    fun toPreferences(token: String?) {
        val editor = pref.edit()
        editor.putString("EDIT_TEXT_KEY", token).apply()
    }

    fun fromPreferences(): String? {
        return pref.getString("EDIT_TEXT_KEY", "")
    }
}