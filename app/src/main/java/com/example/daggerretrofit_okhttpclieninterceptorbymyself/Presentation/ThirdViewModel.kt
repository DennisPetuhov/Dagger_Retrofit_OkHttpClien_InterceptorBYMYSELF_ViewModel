package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ThirdViewModel @Inject constructor(val set:Set<String>):ViewModel() {
}