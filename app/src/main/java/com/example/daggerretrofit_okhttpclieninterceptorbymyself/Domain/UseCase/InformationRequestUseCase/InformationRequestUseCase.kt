package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.InformationRequestUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Repository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class InformationRequestUseCase @Inject constructor(val repo: Repository) :
    InformationRequestUseCaseInterface  {
    override suspend fun getInformationRequestUseCase(): Flow<ApiState<String>> {
        return repo.informationRequest()
    }
}