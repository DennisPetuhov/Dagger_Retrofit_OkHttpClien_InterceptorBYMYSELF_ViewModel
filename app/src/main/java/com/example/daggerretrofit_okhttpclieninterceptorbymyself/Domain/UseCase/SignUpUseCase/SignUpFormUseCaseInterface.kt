package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignUpUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import retrofit2.Response

interface SignUpFormUseCaseInterface {
    suspend fun signUp(sigUpForm: SignUpForm): Response<String>
}