package com.example.daggerretrofit_okhttpclieninterceptorbymyself.App

import android.app.Application
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DI.DaggerMyComponent
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DI.MyComponent


class App : Application(){
    lateinit var myComponent: MyComponent
    override fun onCreate() {
        super.onCreate()
        myComponent= DaggerMyComponent.builder().context(this).build()
    }
}