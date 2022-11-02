package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignUpUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import kotlinx.coroutines.flow.Flow

interface SignUpFormUseCaseInterface {
    suspend fun signUp(sigUpForm: SignUpForm): Flow<ApiState<String>>
}