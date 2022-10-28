package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI

import android.content.Context
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.InfoFragment.InfoFragment
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login.LoginFragment
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login.MainActivity
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Regestration.RegestrationFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [SharedPrefModule::class, ApiModule::class, ViewModelModule::class, SetMapExampleModule::class])

interface MyComponent {
fun inject(mainActivity: MainActivity)
fun inject(loginFragment: LoginFragment)
fun inject (regesterationFragment:RegestrationFragment)
fun inject (infoFragment: InfoFragment)
@Component.Builder
interface Builder{
    @BindsInstance
    fun context(context: Context): Builder

    fun build(): MyComponent
}
}