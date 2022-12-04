package org.sopt.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import org.sopt.sample.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private val signUpViewModel: SignUpViewModel by viewModels()
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        binding.viewmodel = signUpViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        binding.btnSignupfinish.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            if (binding.edtIdEnter.text.length > 6 || binding.edtIdEnter.text.length < 10 && binding.edtPasswordEnter.text.length > 8 || binding.edtPasswordEnter.text.length < 12) {
                intent.putExtra("userId", binding.edtIdEnter.text.toString())
                intent.putExtra("userPassword", binding.edtPasswordEnter.text.toString())
                setResult(RESULT_OK, intent)
                if (!isFinishing) {
                    finish()
                }
            }
        }

        observeId()
        observePassword()
    }

    private fun observeId() {
        signUpViewModel.id.observe(this) {
            if (it.length in 6..10) {

            }
        }

    }

    private fun observePassword() {
        signUpViewModel.password.observe(this) {
            if (it.length in 6..12) {

            }
        }

    }
}
//if (edtInputId.length() > 6 || edtInputId.length() < 10 && edtInputPassword.length() > 8 || edtInputPassword.length() < 12) {
//if (edtInputId.length() in 6..10 && edtInputPassword.length() in 9..11) {