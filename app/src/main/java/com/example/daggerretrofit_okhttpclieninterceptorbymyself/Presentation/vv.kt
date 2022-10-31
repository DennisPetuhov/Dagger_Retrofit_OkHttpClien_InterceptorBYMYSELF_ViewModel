package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

abstract class BaseViewModel : ViewModel() {

    private val _navigation = MutableLiveData<NavigationCommand>()
    val navigation: LiveData<NavigationCommand> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = NavigationCommand.ToDirection(navDirections)
    }

    fun navigateBack() {
        _navigation.value = (NavigationCommand.Back)
    }

}