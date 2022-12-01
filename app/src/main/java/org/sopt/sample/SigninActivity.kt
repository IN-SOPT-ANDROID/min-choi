package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.data.RequestLogin
import org.sopt.sample.data.ResponseLogin
import org.sopt.sample.data.ServicePool
import org.sopt.sample.databinding.ActivitySigninBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            if (binding.edtIdEnter.text.length > 6) {
                Snackbar.make(binding.root, "로그인을 성공했습니다.", Snackbar.LENGTH_SHORT).show()
            }
        }
        registerSignup()
        clickbtnSignup()
        clickbtnLogin()
    }

    private fun registerSignup() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val userId = it.data?.getStringExtra("userId") ?: ""
                    val userPassword = it.data?.getStringExtra("userPassword") ?: ""
                    binding.edtIdEnter.setText(userId)
                    binding.edtPasswordEnter.setText(userPassword)
                }
            }
    }

    private fun clickbtnSignup() {
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun clickbtnLogin() {
        binding.btnLogin.setOnClickListener {
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//            Snackbar.make(binding.root,"로그인 성공",Snackbar.LENGTH_SHORT).show()
//            finish()
            val loginService = ServicePool.loginService

            loginService.login(
                RequestLogin(
                    binding.edtIdEnter.text.toString(),
                    binding.edtPasswordEnter.text.toString()
                )
            ).enqueue(object : Callback<ResponseLogin> {
                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                }
                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    Toast.makeText(this@SigninActivity, "에러 발생", Toast.LENGTH_SHORT).show()
                }
                })
        }
    }

}
