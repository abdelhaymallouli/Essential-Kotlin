package com.solicode.kotlinessentiel.demo

//
fun greet(input: String?): String =
    input
        ?.trim()
        ?.takeIf { it.isNotEmpty() }
        ?.let {"Bonjour, $it !"}
        ?: ""

//
fun parseCount(input: String?): Int =
    input
        ?.trim()
        ?.toIntOrNull()
        ?.coerceAtLeast(0)
        ?: 0

// 3
fun safeAt(xs: List<Int>, index: Int): Int? =
    xs.getOrNull(index) ?: -1

// 4
fun parseAnyToNonNegativeInt(x: Any?): Int =
    (x as? String)?.toIntOrNull()?.coerceAtLeast(0) ?: 0

fun pipeline(name: String?, countText: String?): String =
    "${greet(name)}#${parseCount(countText)}"


// 5
fun lengthOrZero(s: String?): Int = s?.length ?: 0

fun nonNullOrFail(s: String?): String =
    requireNotNull(s) { "Valeur requise non fournie" }


fun main() {
    println("=== DEMO Null-safety ===")

    // 1
    println(greet(null))
    println(greet(""))
    println(greet("Ada"))

    //2
    println(parseCount(null))   // 0
    println(parseCount(" -5 ")) // 0
    println(parseCount(" 12 ")) // 12

    // 3
    println(safeAt(listOf(10, 20), 1))  // 20
    println(safeAt(listOf(10, 20), 9))  // -1

    // 4
    println(parseAnyToNonNegativeInt("42"))   // 42
    println(parseAnyToNonNegativeInt("x"))    // 0
    println(parseAnyToNonNegativeInt(null))   // 0
    println(pipeline(" Ada ", " 12 "))        // "Bonjour, Ada !#12"

    // 5
    println(lengthOrZero(null))     // 0
    println(lengthOrZero("Kotlin")) // 6

    // Exemple positif (évite un crash intentionnel) :
    println(nonNullOrFail("OK"))    // "OK"
}
