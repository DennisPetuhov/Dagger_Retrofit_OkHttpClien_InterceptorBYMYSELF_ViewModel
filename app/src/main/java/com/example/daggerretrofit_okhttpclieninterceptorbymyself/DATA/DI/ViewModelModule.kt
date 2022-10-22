package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presenter.Login.LoginViewModel
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presenter.ThirdViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @ViewModelKey(ThirdViewModel::class)
    @IntoMap
    abstract fun thirdViewModelCreate(thirdViewModel: ThirdViewModel):ViewModel

    @Binds
    @ViewModelKey(LoginViewModel::class)//key of viewmodel
    @IntoMap
    abstract fun loginViewmodelCreate(loginViewModel: LoginViewModel):ViewModel //кладем в мэп
    @Binds
    abstract fun bindViewModelFactory(daggerViewModelFactory: DaggerViewModelFactory):ViewModelProvider.Factory

}