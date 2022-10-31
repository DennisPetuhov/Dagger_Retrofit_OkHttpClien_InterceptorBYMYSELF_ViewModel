package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation

import android.app.Application
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.DaggerMyComponent
//import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.DaggerMyComponent


import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.MyComponent


class App : Application(){
    lateinit var myComponent: MyComponent
    override fun onCreate() {
        super.onCreate()
       myComponent= DaggerMyComponent.builder().context(this).build()
//        myComponent= DaggerMyComponent.create()
    }
}