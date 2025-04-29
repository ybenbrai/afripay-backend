package com.afripay.config

import io.github.cdimascio.dotenv.Dotenv

object Env {
    private val dotenv: Dotenv = Dotenv.configure()
        .ignoreIfMissing()
        .load()

    fun get(key: String, fallback: String? = null): String {
        return dotenv.get(key) ?: fallback ?: throw Exception("Missing env var: $key")
    }
}
