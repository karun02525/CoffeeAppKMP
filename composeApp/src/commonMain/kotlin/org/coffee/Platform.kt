package org.coffee

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform