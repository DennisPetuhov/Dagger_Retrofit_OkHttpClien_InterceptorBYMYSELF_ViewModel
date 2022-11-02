package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignUpUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Repository
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpFormUseCase @Inject constructor(var repository: Repository):SignUpFormUseCaseInterface {
    override suspend fun signUp(sigUpForm: SignUpForm): Flow<ApiState<String>> {
        return repository.signUp(sigUpForm)

    }
}