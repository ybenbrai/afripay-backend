package com.afripay.backend.user

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column(name = "phone_number", unique = true, nullable = false)
    val phoneNumber: String,

    @Column(nullable = false)
    val password: String
)
