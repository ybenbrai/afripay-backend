package com.afripay.backend.auth

data class LoginRequest(
    val phoneNumber: String,
    val password: String
)
