package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login


import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.DeleteDataFromPreferences.DeleteDataFromSharedPreferencesUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseViewModel
import javax.inject.Inject

class InformationViewModel @Inject constructor(
    val deleteDataFromSharedPreferencesfUseCase: DeleteDataFromSharedPreferencesUseCase
) : BaseViewModel() {

   fun deleteDataFromSharedPreferences(key:String){
       deleteDataFromSharedPreferencesfUseCase.deleteSharedPreferences(key)}

}