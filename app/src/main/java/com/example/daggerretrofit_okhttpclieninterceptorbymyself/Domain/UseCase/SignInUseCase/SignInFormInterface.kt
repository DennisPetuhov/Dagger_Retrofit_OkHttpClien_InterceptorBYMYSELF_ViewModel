package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SignInUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.CommentApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.ResponseSignIn
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SignInFormInterface {
    suspend fun signIn(signInForm: SignInForm) : Flow<CommentApiState<ResponseSignIn>>
}