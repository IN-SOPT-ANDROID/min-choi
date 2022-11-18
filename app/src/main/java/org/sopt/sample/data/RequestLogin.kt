package org.sopt.sample.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLogin(
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String,
)
