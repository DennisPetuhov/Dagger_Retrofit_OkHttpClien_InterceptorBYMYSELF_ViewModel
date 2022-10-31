package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.ToSharedPrefUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Repository
import javax.inject.Inject

class ToSharedPrefUseCase @Inject constructor(var repo: Repository) : ToSharedPrefUseCaseInetrface<String> {
    override fun toSharedPrefUseCase(token: String?):Unit {
       return repo.toPreferences(token)
    }




}