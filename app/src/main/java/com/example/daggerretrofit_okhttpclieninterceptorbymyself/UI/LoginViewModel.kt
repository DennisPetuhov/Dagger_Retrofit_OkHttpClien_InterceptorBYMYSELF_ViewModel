package com.example.daggerretrofit_okhttpclieninterceptorbymyself.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.MainActivity
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT.SignInForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.RETROFIT.SignUpForm
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginViewModel @Inject constructor(val repo: Repository) : ViewModel() {

    var tokenLivedata: MutableLiveData<String> = MutableLiveData()

    fun signUp(sigUpForm: SignUpForm) {
        viewModelScope.launch(Dispatchers.IO) {
            var response = repo.signUp(sigUpForm)
            if (response.isSuccessful) {

            }
        }
    }

    fun signIn(signInForm: SignInForm) {
        viewModelScope.launch(Dispatchers.IO) {
            var response = repo.signIn(signInForm)
            if (response.isSuccessful) {
                var body = response.body()
                var token = body?.accessToken
                toPreferences(token)
                tokenLivedata.value=token?:""
            }
        }
    }


    fun getInfo() {
        viewModelScope.launch(Dispatchers.IO) { repo.getInfo() }
    }


    fun toPreferences(token: String?) {
        repo.toPreferences(token)
    }

    fun fromPreferences(): String? {
        return repo.fromPreferences()
    }

}