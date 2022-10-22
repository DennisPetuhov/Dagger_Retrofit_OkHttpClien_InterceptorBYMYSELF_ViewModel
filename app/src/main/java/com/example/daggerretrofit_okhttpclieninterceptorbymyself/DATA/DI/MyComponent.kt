package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI

import android.content.Context
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presenter.Login.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [SharedPrefModule::class, ApiModule::class, ViewModelModule::class, SetMapExampleModule::class])

interface MyComponent {
fun inject(mainActivity: MainActivity)
@Component.Builder
interface Builder{
    @BindsInstance
    fun context(context: Context): Builder

    fun build(): MyComponent
}
}