package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.InformationFragment.InformationViewModel
//import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login.AfterLoginViewModel
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login.LoginViewModel
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Regestration.RegestrationViewModel
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.ThirdViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @ViewModelKey(ThirdViewModel::class)
    @IntoMap
    abstract fun thirdViewModelCreate(thirdViewModel: ThirdViewModel): ViewModel

    @Binds
    @ViewModelKey(LoginViewModel::class)//key of viewmodel
    @IntoMap
    abstract fun loginViewmodelCreate(loginViewModel: LoginViewModel): ViewModel //кладем в мэп

    @Binds
    @ViewModelKey(InformationViewModel::class)
    @IntoMap
    abstract fun afterLoginViewModelCreate(informationViewModel: InformationViewModel):ViewModel

    @Binds
    @ViewModelKey(RegestrationViewModel::class)
    @IntoMap
    abstract fun afterRegistrationViewModelCreate(regestrationViewModel: RegestrationViewModel):ViewModel

    @Binds
    abstract fun bindViewModelFactory(daggerViewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}