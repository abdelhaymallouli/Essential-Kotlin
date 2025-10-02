package com.solicode.kotlinessentiel.demo

fun main() {
    // 1- val vs var + inference
    val name = "KotlinEssentiel"  // immutable
    var count = 0           // mutable,
    val versionCode: Int = 1  // explicit type
    val user = "Ada"

    println("Nom app : $name, version: $versionCode, user: $user, count: $count")

    count++
    println("After increment: count=$count")

    // --- 2) Conditions with when ---
    println("Label 0 → ${levelLabel(0)}")
    println("Label 7 → ${levelLabel(7)}")
    println("Label 42 → ${levelLabel(42)}")

    // --- 3) Loops with ranges ---
    println("Somme 0..5 = ${sum0to(5)}")
}

// Function using when
fun levelLabel(count : Int): String = when {
    count < 0 -> "Invalide"
    count == 0 -> "Début"
    count in 1..9 -> "bas"
    count in 10..99 -> "Moyen"
    else -> "Eleve"
}


// function with loop
fun sum0to(n: Int): Int {
    require(n >= 0)
    var s = 0
    for (i in 0..n) {
     s += i
    }
    return s
}