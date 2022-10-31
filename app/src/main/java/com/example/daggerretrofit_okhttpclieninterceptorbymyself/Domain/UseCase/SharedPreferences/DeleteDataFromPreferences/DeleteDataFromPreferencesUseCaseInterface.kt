package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.DeleteDataFromPreferences



interface DeleteDataFromPreferencesUseCaseInterface  {
    fun deleteSharedPreferences(key:String):Unit
}