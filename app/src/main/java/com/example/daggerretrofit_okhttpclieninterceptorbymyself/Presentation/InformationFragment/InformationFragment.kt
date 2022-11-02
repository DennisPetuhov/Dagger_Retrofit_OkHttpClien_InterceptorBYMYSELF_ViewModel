package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.InformationFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.DaggerViewModelFactory
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.MyComponent
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseFragment
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login.MainActivity

import com.example.daggerretrofit_okhttpclieninterceptorbymyself.databinding.InformationFragmentBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class InformationFragment : BaseFragment() {

    companion object {
        fun newInstance() = InformationFragment()
    }
    lateinit var component: MyComponent


    @Inject
     lateinit var viewModelFactory: DaggerViewModelFactory




    lateinit var binding: InformationFragmentBinding
    lateinit var vm: InformationViewModel







    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      component=  (requireActivity() as MainActivity).myComponent
          component.inject(this)
        vm = ViewModelProvider(this, viewModelFactory).get(InformationViewModel::class.java)
        binding = InformationFragmentBinding.inflate(inflater, container, false)
        vm.informationRequest()


        observeNavigation(vm)
        observeTextChanges()
        observeInformationRequestAfterLogin()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogOut.setOnClickListener {
            val action =
                InformationFragmentDirections.actionAfterLoginFragmentToLoginFragment()
            vm.deleteDataFromSharedPreferences("EDIT_TEXT_KEY")
            vm.navigate(action)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AfterLoginViewModel::class.java)

    }
    fun observeTextChanges(){
        viewLifecycleOwner.lifecycleScope.launch(){
            repeatOnLifecycle(Lifecycle.State.STARTED){
                vm.textFlow.collect{
                    binding.textView.text=it


                }

            }
        }


    }


    private fun observeInformationRequestAfterLogin() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.flowInformationRequest.collect {
                    println(it)
                    when (it.status) {
                        Status.ERROR -> {
                            println("EROOR1" + it.msg)
                        }
                        Status.SUCCESS -> {
                            println(it.data)
                            binding.textView.text=it.data


                        }
                        Status.LOADING -> {
                            println(it.data)
                        }
                    }

                }
            }
        }
    }

}