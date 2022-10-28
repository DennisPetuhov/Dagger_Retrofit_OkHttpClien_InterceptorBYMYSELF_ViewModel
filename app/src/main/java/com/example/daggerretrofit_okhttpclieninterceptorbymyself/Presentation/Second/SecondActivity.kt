package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.Second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}