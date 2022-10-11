package org.sopt.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.sample.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignupfinish.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            if (binding.edtIdEnter.text.length > 6 || binding.edtIdEnter.text.length < 10 && binding.edtPasswordEnter.text.length > 8 || binding.edtPasswordEnter.text.length < 12) {
                intent.putExtra("userId", binding.edtIdEnter.text.toString())
                intent.putExtra("userPassword", binding.edtPasswordEnter.text.toString())
                setResult(RESULT_OK, intent)
                if (!isFinishing) {
                    finish()
                }
            }
        }
    }
}
//if (edtInputId.length() > 6 || edtInputId.length() < 10 && edtInputPassword.length() > 8 || edtInputPassword.length() < 12) {
//if (edtInputId.length() in 6..10 && edtInputPassword.length() in 9..11) {