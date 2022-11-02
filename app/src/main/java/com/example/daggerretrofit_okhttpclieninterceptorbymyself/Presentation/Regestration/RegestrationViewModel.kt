package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Regestration



import androidx.lifecycle.viewModelScope
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignUpUseCase.SignUpFormUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegestrationViewModel @Inject constructor(val signUpUseCase: SignUpFormUseCase) :
    BaseViewModel() {

    val flowSignUp: StateFlow<ApiState<String>> get() = mutableFlowSignUp

    private var mutableFlowSignUp: MutableStateFlow<ApiState<String>> =
        MutableStateFlow(ApiState("", Status.LOADING, null))

    fun signUp(signUpForm: SignUpForm) {
        mutableFlowSignUp.value = ApiState.loading()
        viewModelScope.launch(Dispatchers.IO) {
             signUpUseCase.signUp(signUpForm).catch {
                mutableFlowSignUp.value = ApiState.error(it.message.toString())
            }.collect {
                mutableFlowSignUp.value = ApiState.success(it.data)

            }
        }
    }

}