package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.GetInfoUseCase

import retrofit2.Response

interface GetInfoFormUseCaseInterface {
    suspend fun getInfo(): Response<String>
}