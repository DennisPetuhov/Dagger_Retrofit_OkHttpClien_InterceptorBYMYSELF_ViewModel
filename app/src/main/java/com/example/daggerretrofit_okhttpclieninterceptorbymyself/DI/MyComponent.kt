package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DI

import android.content.Context
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [SharedPrefModule::class,ApiModule::class, ViewModelModule::class])

interface MyComponent {
fun inject(mainActivity: MainActivity)
@Component.Builder
interface Builder{
    @BindsInstance
    fun context(context: Context):Builder

    fun build():MyComponent
}
}