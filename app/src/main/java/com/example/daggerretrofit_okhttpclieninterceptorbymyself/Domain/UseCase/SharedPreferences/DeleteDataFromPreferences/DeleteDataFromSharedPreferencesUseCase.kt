package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.DeleteDataFromPreferences

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Repository
import javax.inject.Inject

class DeleteDataFromSharedPreferencesUseCase @Inject constructor(var repo: Repository) :
    DeleteDataFromPreferencesUseCaseInterface {


    override fun deleteSharedPreferences(key: String): Unit {
        return repo.deleteDataFromPreferences(key)
    }


}