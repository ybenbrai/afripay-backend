package com.afripay.backend.auth

import com.afripay.backend.security.JwtService
import com.afripay.backend.user.User
import com.afripay.backend.user.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepo: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService
) {
    fun register(request: RegisterRequest): String {
    if (userRepo.findByPhoneNumber(request.phoneNumber) != null) {
        throw IllegalArgumentException("Phone number already registered")
    }

    val user = User(
        phoneNumber = request.phoneNumber,
        password = passwordEncoder.encode(request.password)
    )
    userRepo.save(user)
    
    return jwtService.generateToken(
        org.springframework.security.core.userdetails.User(
            user.phoneNumber,
            user.password,
            emptyList()
        )
    )
}


   fun login(request: LoginRequest): String {
    val user = userRepo.findByPhoneNumber(request.phoneNumber)
        ?: throw IllegalArgumentException("Invalid credentials")

    if (!passwordEncoder.matches(request.password, user.password)) {
        throw IllegalArgumentException("Invalid credentials")
    }

    return jwtService.generateToken(
        org.springframework.security.core.userdetails.User(
            user.phoneNumber,
            user.password,
            emptyList()
        )
    )
}

}
