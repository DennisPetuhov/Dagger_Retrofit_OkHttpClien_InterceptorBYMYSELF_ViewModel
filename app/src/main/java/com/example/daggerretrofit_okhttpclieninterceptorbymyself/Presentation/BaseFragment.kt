package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

open class BaseFragment :Fragment()  {
    private fun handleNavigation(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.ToDirection ->findNavController().navigate(navCommand.navDirections)
            is NavigationCommand.Back -> findNavController().navigateUp()
        }

    }


    fun observeNavigation(viewModel:BaseViewModel){
        viewModel.navigation.observe(viewLifecycleOwner){
            handleNavigation(it)
            println(it.toString()+"?????????????")
        }

    }


}

sealed class NavigationCommand {
    data class ToDirection(val navDirections: NavDirections) : NavigationCommand()

    object Back : NavigationCommand()
}
