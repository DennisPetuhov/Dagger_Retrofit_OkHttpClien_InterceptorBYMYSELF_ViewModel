package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignUpUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Repository
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import retrofit2.Response
import javax.inject.Inject

class SignUpFormUseCase @Inject constructor(var repository: Repository):SignUpFormUseCaseInterface {
    override suspend fun signUp(sigUpForm: SignUpForm): Response<String> {
        return repository.signUp(sigUpForm)

    }
}