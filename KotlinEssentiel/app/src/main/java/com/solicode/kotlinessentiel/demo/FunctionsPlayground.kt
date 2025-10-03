package com.solicode.kotlinessentiel.demo

// Fonctions finales (exemples)
fun celsiusToF(c: Double) = c * 9 / 5 + 32
fun greet(name: String, punctuation: String = "!") =
    "Bonjour, ${name.trim()}$punctuation"
fun avg(vararg numbers: Int) = numbers.average()
fun String.sanitized() = trim().replace(Regex("\\s+"), " ")

// Lambdas finales (exemples)
val square = { x: Int -> x * x }
val shout: (String) -> String = { it.uppercase() }

// main() FINAL — à livrer
fun main() {
    // 1) expression body
    println(celsiusToF(0.0))       // 32.0
    println(celsiusToF(100.0))     // 212.0

    // 2) valeurs par défaut + nommés
    println(greet("Ada"))                          // Bonjour, Ada!
    println(greet(name = "Alan", punctuation = "!!")) // Bonjour, Alan!!

    // 3) vararg (+ spread)
    println(avg(1, 2, 3, 4))       // 2.5
    val arr = intArrayOf(2, 4, 6)
    println(avg(*arr))             // 4.0

    // 4) lambdas
    println(square(5))             // 25
    println(shout("kotlin"))       // KOTLIN

    // 5) extension
    println("  Hello   Kotlin  ".sanitized()) // Hello Kotlin
}
