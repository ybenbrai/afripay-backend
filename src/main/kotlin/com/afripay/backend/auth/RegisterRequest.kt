package com.afripay.backend.auth

data class RegisterRequest(
    val phoneNumber: String,
    val password: String
)
