package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.GetInfoUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Repository
import retrofit2.Response
import javax.inject.Inject

class GetInfoFormUseCase @Inject constructor( var repo:Repository) :GetInfoFormUseCaseInterface{
    override suspend fun getInfo(): Response<String> {
        return repo.getInfo()!!

    }
}