package org.sopt.sample.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignin(
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: LoginResult,
    @SerialName("status")
    val status: Int
)
