package org.sopt.sample.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/user/signin")
    fun login(@Body request: RequestLogin): Call<ResponseLogin>

    @POST("api/user/signup")
    suspend fun signUp(@Body request: RequestSignin): Call<ResponseSignin>
}

