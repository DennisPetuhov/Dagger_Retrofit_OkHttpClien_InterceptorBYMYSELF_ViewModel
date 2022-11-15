package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login

import android.content.SharedPreferences
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.DaggerViewModelFactory
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseFragment

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.databinding.FragmentLoginBinding

import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    @Inject
    lateinit var daggerViewModelFactory: DaggerViewModelFactory

    @Inject
    lateinit var pref: SharedPreferences


    lateinit var binding: FragmentLoginBinding
    lateinit var vm: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).myComponent.inject(this)
        vm = ViewModelProvider(this, daggerViewModelFactory).get(LoginViewModel::class.java)
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        observeNavigation(vm)
        observeChanges()
      
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.signIn.setOnClickListener {
            val signin = SignInForm(
                binding.textUserName.text.toString(),

                binding.textPassword.text.toString()
            )

//            findNavController().navigate(R.id.afterLoginFragment)

            vm.signIn(signin)
            println(
                SignInForm(
//                    binding.textUserName.text.toString(),
                    binding.textUserName.text.toString(),
                    binding.textPassword.text.toString()
                )
            )


        }

        binding.buttonRegistrarion.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegestrationFragment()
            vm.navigate(action)
        }

    }

    private fun observeChanges() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.flowSignIn.collect {
                    println(it)
                    when (it.status) {
                        Status.ERROR -> {
                            println("EROOR" + it.msg)
                        }
                        Status.SUCCESS -> {
                            println(it.data)
                            val loginDerection =
                                LoginFragmentDirections.actionLoginFragmentToAfterLoginFragment()
                            vm.navigate(loginDerection)


                        }
                        Status.LOADING -> {
                            println(it.data)
                        }
                    }

                }
            }
        }
    }



    fun toPreferences(token: String?) {
        val editor = pref.edit()
        editor.putString("EDIT_TEXT_KEY", token).apply()
    }

    fun fromPreferences(): String? {
        return pref.getString("EDIT_TEXT_KEY", "")
    }

//    companion object {
//        private const val EDIT_TEXT_KEY = "EDIT_TEXT_KEY"
//        const val app_preferences = "app_preferences"
//
//    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        vm = ViewModelProvider(this).get(LoginViewModel::class.java)
//
//    }

}