package com.solicode.kotlinessentiel.demo.GoodPractices

// Main.kt

data class User(val id: Long, val name: String)

fun String.isEmailValid(): Boolean {
    return this.contains("@")
}

fun main() {
    val users = listOf(User(1, "Alice"), User(2, "Bob"))

    users.forEach { user ->
        println("User: ${user.name}")
    }

    val email = "test@example.com"
    println("Is email valid? ${email.isEmailValid()}")
}
