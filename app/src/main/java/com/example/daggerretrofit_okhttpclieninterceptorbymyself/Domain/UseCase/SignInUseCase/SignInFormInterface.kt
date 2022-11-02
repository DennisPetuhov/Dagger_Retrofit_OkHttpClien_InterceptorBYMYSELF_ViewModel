package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignInUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.ResponseSignIn
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import kotlinx.coroutines.flow.Flow

interface SignInFormInterface {
    suspend fun signIn(signInForm: SignInForm) : Flow<ApiState<ResponseSignIn>>
}