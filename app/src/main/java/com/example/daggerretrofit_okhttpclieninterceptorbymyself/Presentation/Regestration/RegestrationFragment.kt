package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Regestration

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.DaggerViewModelFactory
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.MyComponent
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseFragment
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login.MainActivity

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.databinding.FragmentRegestrationBinding

import kotlinx.coroutines.launch
import javax.inject.Inject

class RegestrationFragment : BaseFragment() {

    companion object {
        fun newInstance() = RegestrationFragment()
    }

    @Inject
    lateinit var vmFactory: DaggerViewModelFactory
    lateinit var binding: FragmentRegestrationBinding

    lateinit var vm: RegestrationViewModel
    lateinit var myComponent: MyComponent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        myComponent = (requireActivity() as MainActivity).myComponent
        myComponent.inject(this)
        vm = ViewModelProvider(this, vmFactory).get(RegestrationViewModel::class.java)
        binding = FragmentRegestrationBinding.inflate(inflater, container, false)
        observeChanges()
        observeNavigation(vm)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSignUp()
        buttonBack()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    fun buttonBack() {
        binding.buttonBack.setOnClickListener {
            val action = RegestrationFragmentDirections.actionRegestrationFragmentToLoginFragment()
            vm.navigate(action)
        }
    }

    fun buttonSignUp() {
        binding.signUp.setOnClickListener {
            with(binding) {
                val password1 = password.text.toString()
                val password2 = password2.text.toString()
                val name = name.text.toString()
                val userName = username.text.toString()
                val email = email.text.toString()
                val signUpForm = SignUpForm(name, userName, email, arrayOf(), password1)


                if (password1.equals(password2)) {
                    vm.signUp(signUpForm)

                }


            }
        }
    }

    private fun observeChanges() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.flowSignUp.collect {
                    when (it.status) {
                        Status.ERROR -> {
                            println(it)
                        }
                        Status.SUCCESS -> {
                            println(it)
                            Toast.makeText(requireActivity(), it.data, Toast.LENGTH_LONG).show()
                            val direction =
                                RegestrationFragmentDirections.actionRegestrationFragmentToLoginFragment()
                            vm.navigate(direction)

                        }
                        Status.LOADING -> {
                            println(it)
                        }
                    }
                }

            }
        }

    }

}