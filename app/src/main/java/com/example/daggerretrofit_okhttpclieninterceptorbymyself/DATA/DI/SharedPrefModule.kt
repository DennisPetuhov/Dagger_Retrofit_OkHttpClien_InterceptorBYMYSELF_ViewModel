package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI

import android.content.Context
import android.content.SharedPreferences
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presenter.Login.MainActivity.Companion.app_preferences
import dagger.Module
import dagger.Provides

@Module()

class SharedPrefModule {
    @Provides
    fun provideSharedPref(context: Context):SharedPreferences{
        return context.getSharedPreferences(app_preferences,Context.MODE_PRIVATE)
    }
}