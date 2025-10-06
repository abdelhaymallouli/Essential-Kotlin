package com.solicode.kotlinessentiel.demo.classes

fun main() {
    println("--- Étape 1: Classe classique par défaut ---")
    val pc1 = PersonClassic("Ada", 36)
    val pc2 = PersonClassic("Ada", 36)
    println("pc1 == pc2 ? ${pc1 == pc2}") // false si equals non défini, true avec override
    println("toString(): $pc1") // PersonClassic(name=Ada, age=36)


    println("\n--- Étape 2: copy manuel (PersonClassic) ---")
    val pc3 = pc1.copy(age = 37)
    println("pc3 (copie): $pc3")


    println("\n--- Étape 3: Data class ---")
    val pd1 = PersonData("Ada", 36)
    val pd2 = PersonData("Ada", 36)
    println("pd1 == pd2 ? ${pd1 == pd2}") // true (égalité par contenu)
    println("toString(): $pd1") // PersonData(name=Ada, age=36)


    val pd3 = pd1.copy(age = 37)
    println("pd3 (copie): $pd3") // PersonData(name=Ada, age=37)


    val (n, a) = pd3
    println("Déstructuration → Nom=$n, âge=$a")


    println("\n--- Étape 4: Collections ---")
    val s1 = setOf(
        PersonClassic("Ada", 36),
        PersonClassic("Ada", 36)
    )
    println("Set (classique) taille = ${s1.size}") // 2


    val s2 = setOf(
        PersonData("Ada", 36),
        PersonData("Ada", 36)
    )
    println("Set (data class) taille = ${s2.size}") // 1


    val map = mapOf(
        PersonData("Ada", 36) to "Dev",
        PersonData("Ada", 36) to "Scientist"
    )
    println("Map: $map") // une seule entrée, clé unique par contenu
}