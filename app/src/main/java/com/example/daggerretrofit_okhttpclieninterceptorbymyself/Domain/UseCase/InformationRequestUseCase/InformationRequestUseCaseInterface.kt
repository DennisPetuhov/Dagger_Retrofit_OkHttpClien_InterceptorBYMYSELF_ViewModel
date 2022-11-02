package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.InformationRequestUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface InformationRequestUseCaseInterface {
  suspend  fun getInformationRequestUseCase(): Flow<ApiState<String>>
}