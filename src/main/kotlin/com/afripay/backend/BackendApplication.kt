package com.afripay.backend

import com.afripay.config.Env
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    // Inject .env values manually
    System.setProperty("spring.datasource.url", "jdbc:postgresql://${Env.get("DB_HOST")}:${Env.get("DB_PORT")}/${Env.get("DB_NAME")}")
    System.setProperty("spring.datasource.username", Env.get("DB_USER"))
    System.setProperty("spring.datasource.password", Env.get("DB_PASS"))
    System.setProperty("server.port", Env.get("PORT", "8080"))

    runApplication<BackendApplication>(*args)
}
