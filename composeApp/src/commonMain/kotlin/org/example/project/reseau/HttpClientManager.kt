package org.example.project.reseau

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.costant.shared.HttpConstant


fun createHttpClient() = HttpClient {
    install(ContentNegotiation) {
        json(
            Json {
                encodeDefaults = true
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            }
        )
    }
    defaultRequest {
        host = HttpConstant.baseUrl
        port = HttpConstant.basePort
    }
}
