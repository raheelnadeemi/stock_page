package com.example.axisassignment

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform