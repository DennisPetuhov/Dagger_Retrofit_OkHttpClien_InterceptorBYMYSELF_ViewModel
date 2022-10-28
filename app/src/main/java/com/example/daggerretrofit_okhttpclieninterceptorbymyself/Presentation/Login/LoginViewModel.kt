package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login

import androidx.lifecycle.MutableLiveData
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.CommentApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.FromSharedPreUseCase.FromSharedPrefUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.GetInfoUseCase.GetInfoFormUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.ResponseSignIn
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignUpUseCase.SignUpFormUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.ToSharedPrefUseCase.ToSharedPrefUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignInUseCase.SignInFormUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class LoginViewModel @Inject constructor(

    val fromSharedPrefUseCase: FromSharedPrefUseCase,
    var signInUseCase: SignInFormUseCase,
    val signUpUseCase: SignUpFormUseCase,
    val getInfoUsecase: GetInfoFormUseCase,
    val toSharedPrefUseCase: ToSharedPrefUseCase
) : BaseViewModel() {

    var tokenLivedata: MutableLiveData<String> = MutableLiveData()


    val flowSignIn: StateFlow<CommentApiState<ResponseSignIn>> get() = mutableFlowSignIn
    private var mutableFlowSignIn: MutableStateFlow<CommentApiState<ResponseSignIn>> =
        MutableStateFlow(CommentApiState(ResponseSignIn(), Status.LOADING, null))

    fun signUp(sigUpForm: SignUpForm) {
        viewModelScope.launch(Dispatchers.IO) {
            var response = signUpUseCase.signUp(sigUpForm)
            if (response.isSuccessful) {

            }
        }
    }






    fun signIn(signInForm: SignInForm) {
        mutableFlowSignIn.value = CommentApiState.loading()
        viewModelScope.launch(Dispatchers.IO) {
            //  var response = repo.signIn(signInForm)


            signInUseCase.signIn(signInForm)
                .catch {
                    mutableFlowSignIn.value = CommentApiState.error(
                        it.message.toString()
                    )
                }
                .collect {
                    mutableFlowSignIn.value = CommentApiState.success(
                        it.data

                    )
                }


//            if (response.isSuccessful) {
//                var body = response.body()
//                var token = body?.accessToken
//                toPreferences(token)
//                tokenLivedata.value = token ?: ""
//            }
        }
    }


    fun getInfo() {
        viewModelScope.launch(Dispatchers.IO) { getInfoUsecase.getInfo() }
    }


    fun toPreferences(token: String?) {
        toSharedPrefUseCase.toSharedPrefUseCase(token)
    }

    fun fromPreferences(): String? {
        return fromSharedPrefUseCase.fromSharedPref()
    }

}