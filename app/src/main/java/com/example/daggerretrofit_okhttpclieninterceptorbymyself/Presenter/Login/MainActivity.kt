package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presenter.Login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.DaggerViewModelFactory
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.DI.MyComponent
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.MyApi
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignInForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.SignUpForm
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presenter.App
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var myComponent: MyComponent
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var map: Map<String, String>

    @Inject
    lateinit var setOfString: Set<String>

    @Inject
    lateinit var daggerViewModelFactory: DaggerViewModelFactory

    @Inject
    lateinit var api: MyApi

    @Inject
    lateinit var pref: SharedPreferences


    val signup = SignUpForm(
        "admin",
        "admin",
        "admin@admin.ru",
        arrayOf(),
        "admin"

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        myComponent = (applicationContext as App).myComponent
        myComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var vm = ViewModelProvider(this, daggerViewModelFactory).get(LoginViewModel::class.java)
//        val signin = SignInForm(binding.textUserName.text.toString(),binding.textPassword.text.toString() )
        // val signin = SignInForm("DDDD","DDDDD" )

        binding.signIn.setOnClickListener {
            val signin = SignInForm(
                binding.textUserName.text.toString(),
                binding.textPassword.text.toString()
            )
            //  signInFun(signin)
            vm.signIn(signin)
            println(
                SignInForm(
                    binding.textUserName.text.toString(),
                    binding.textPassword.text.toString()
                )
            )
        }
        binding.signUp.setOnClickListener {
            registration(signup)
        }
        binding.getInfo.setOnClickListener { getInfo() }
        lifecycleScope.launch {
            vm.flowSignIn.collect {
                println(it)
                when (it.status) {
                    Status.ERROR -> {
                        println(it.msg)
                    }
                    Status.SUCCESS -> {
                        println(it.data)
                    }
                    Status.LOADING -> {
                        println(it.data)
                    }
                }

            }
        }

        println(setOfString)
        println(map["key1"])

    }

    private fun getInfo() {
        val token = fromPreferences()
        lifecycleScope.launch(Dispatchers.IO) {
            val response = fromPreferences()?.let { api.helloadmin2("Bearer $it") }
            if (response!!.isSuccessful) {
                var body = response.body()
                lifecycleScope.launch(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, body, Toast.LENGTH_SHORT).show()
                }

            } else {
                lifecycleScope.launch(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "response.message()", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }
    }

//    fun signInFun(signIn: SignInForm)
//    {
//        println(signIn.toString()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
//        lifecycleScope.launch(Dispatchers.IO) {
//            var response = api.signIn(signIn)
//            if (response.isSuccessful) {
//                val a = response.body()
//                lifecycleScope.launch(Dispatchers.Main) {
//                    Toast.makeText(this@MainActivity, a?.accessToken, Toast.LENGTH_SHORT).show()
//                }
//                println(a)
//                toPreferences(a?.accessToken)
//
//            } else {
//                if(response.message().isBlank()){
//                    lifecycleScope.launch(Dispatchers.Main) {
//                        Toast.makeText(this@MainActivity, "RESPONSE IS BLANCK", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                println(response.message()
//                +"WRONG EMAIL"+response.message().toString())
//                lifecycleScope.launch(Dispatchers.Main) {
//                    Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT).show()
//                }
//
//            }
//
//        }
//    }

    fun registration(signUp: SignUpForm) {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = api.signUp(signUp)
            if (response.isSuccessful) {
                val b: String? = response.body()
                lifecycleScope.launch(Dispatchers.Main) {

                    Toast.makeText(this@MainActivity, b, Toast.LENGTH_SHORT).show()
                }
            } else {

                lifecycleScope.launch(Dispatchers.Main) {

                    Toast.makeText(this@MainActivity, "*****", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }

    fun toPreferences(token: String?) {
        val editor = pref.edit()
        editor.putString(EDIT_TEXT_KEY, token).apply()
    }

    fun fromPreferences(): String? {
        return pref.getString(EDIT_TEXT_KEY, "")
    }

    companion object {
        private const val EDIT_TEXT_KEY = "EDIT_TEXT_KEY"
        const val app_preferences = "app_preferences"

    }
}


