package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Regestration

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseFragment
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.R

class RegestrationFragment : BaseFragment() {

    companion object {
        fun newInstance() = RegestrationFragment()
    }

    private lateinit var viewModel: RegestrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_regestration, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegestrationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}