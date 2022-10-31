package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.FromSharedPreUseCase

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Repository
import javax.inject.Inject

class FromSharedPrefUseCase @Inject constructor(var repo:Repository):FromSharedPrefUseCaseInetrface {
    override fun fromSharedPref(): String? {
        return repo.fromPreferences()

    }
}