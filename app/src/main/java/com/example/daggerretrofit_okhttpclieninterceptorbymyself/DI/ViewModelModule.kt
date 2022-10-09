package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.UI.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ViewModelKey(LoginViewModel::class)//key
    @IntoMap
    abstract fun loginViewmodelCreate(loginViewModel:LoginViewModel):ViewModel
    @Binds
    abstract fun bindViewModelFactory(daggerViewModelFactory: DaggerViewModelFactory):ViewModelProvider.Factory

}