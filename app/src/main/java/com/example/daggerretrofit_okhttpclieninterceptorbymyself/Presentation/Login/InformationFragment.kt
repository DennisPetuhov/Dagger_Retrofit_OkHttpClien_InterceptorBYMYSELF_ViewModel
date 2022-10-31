package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.DaggerViewModelFactory
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.MyComponent
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseFragment
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.databinding.FragmentAfterLoginBinding
import javax.inject.Inject

class InformationFragment : BaseFragment() {

    companion object {
        fun newInstance() = InformationFragment()
    }
    lateinit var component: MyComponent


    @Inject
     lateinit var viewModelFactory: DaggerViewModelFactory




    lateinit var binding: FragmentAfterLoginBinding
    lateinit var vm: InformationViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      component=  (requireActivity() as MainActivity).myComponent
          component.inject(this)
        vm = ViewModelProvider(this, viewModelFactory).get(InformationViewModel::class.java)
        binding = FragmentAfterLoginBinding.inflate(inflater, container, false)

        observeNavigation(vm)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogOut.setOnClickListener {
            val action = InformationFragmentDirections.actionAfterLoginFragmentToLoginFragment()
            vm.deleteDataFromSharedPreferences("EDIT_TEXT_KEY")
            vm.navigate(action)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AfterLoginViewModel::class.java)

    }

}