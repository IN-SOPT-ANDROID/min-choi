package com.spot.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.sample.LoginViewModel
import org.sopt.sample.R

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.btnMainLogin.setOnClickListener {
//            viewModel.login(
//                binding.etMainId.text.toString(),
//                binding.etMainPassword.text.toString()
//            )
//        }
    }
}
