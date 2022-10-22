package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

@Module
class SetMapExampleModule {
    @IntoSet
    @Provides
    fun provideString1():String{
        return "String1"
    }
    @IntoSet
    @Provides
    fun provideString2():String{
        return "String2"
    }
    @IntoMap
    @StringKey("key1")
    @Provides
    fun provideString3():String{
        return "String3"
    }

}