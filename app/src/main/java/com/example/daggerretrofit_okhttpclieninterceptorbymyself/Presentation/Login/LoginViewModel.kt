package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login

import androidx.lifecycle.MutableLiveData
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.FromSharedPreUseCase.FromSharedPrefUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.GetInfoUseCase.GetInfoFormUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.ResponseSignIn
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.InformationRequestUseCase.InformationRequestUseCase
//import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignUpUseCase.SignUpFormUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.ToSharedPrefUseCase.ToSharedPrefUseCase
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
    val informationRequestUseCase: InformationRequestUseCase,
    val getInfoUsecase: GetInfoFormUseCase,
    val toSharedPrefUseCase: ToSharedPrefUseCase
) : BaseViewModel() {

    var tokenLivedata: MutableLiveData<String> = MutableLiveData()


    val flowSignIn: StateFlow<ApiState<ResponseSignIn>> get() = mutableFlowSignIn
    private var mutableFlowSignIn: MutableStateFlow<ApiState<ResponseSignIn>> =
        MutableStateFlow(ApiState(ResponseSignIn(), Status.LOADING, null))



//    fun signUp(sigUpForm: SignUpForm) {
//        viewModelScope.launch(Dispatchers.IO) {
//            var response = signUpUseCase.signUp(sigUpForm)
//            if (response.isSuccessful) {
//
//            }
//        }
//    }


    fun signIn(signInForm: SignInForm) {
        mutableFlowSignIn.value = ApiState.loading()
        viewModelScope.launch(Dispatchers.IO) {
            //  var response = repo.signIn(signInForm)


            signInUseCase.signIn(signInForm)
                .catch {
                    mutableFlowSignIn.value = ApiState.error(
                        it.message.toString()
                    )
                }
                .collect {

                    val token = it.data?.accessToken
                    mutableFlowSignIn.value = ApiState.success(
                        it.data


                    )

//
                    toSharedPrefUseCase.toSharedPrefUseCase(token)
                }



        }


//            if (response.isSuccessful) {
//                var body = response.body()
//                var token = body?.accessToken
//                toPreferences(token)
//                tokenLivedata.value = token ?: ""
//            }
    }



}


//    fun getInfo() {
//        viewModelScope.launch(Dispatchers.IO) { getInfoUsecase.getInfo() }
//    }
//
//
//    fun fromPreferences(): String? {
//        return fromSharedPrefUseCase.fromSharedPref()
//    }

