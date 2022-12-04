package org.sopt.sample

import android.support.v4.os.IResultReceiver._Parcel
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.data.RequestLogin
import org.sopt.sample.data.ResponseLogin
import org.sopt.sample.data.ServicePool.loginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private val _isCompletedLogIn = MutableLiveData<Boolean>()
    val isCompletedLogIn: LiveData<Boolean> get() = _isCompletedLogIn

    fun logIn(email: String, password: String) {

        loginService.login(RequestLogin(email, password)).enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(
                call: Call<ResponseLogin>,
                response: Response<ResponseLogin>
            ) {
                Log.d("LoginViewModel", response.body().toString())
                _isCompletedLogIn.value = true
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                _isCompletedLogIn.value = false

            }
        })
    }
}
