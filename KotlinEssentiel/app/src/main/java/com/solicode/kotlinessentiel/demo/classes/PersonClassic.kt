package com.solicode.kotlinessentiel.demo.classes

class PersonClassic(val name: String, val age: Int) {
    // Version avec overrides manuels
    override fun toString(): String = "PersonClassic(name=$name, age=$age)"


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PersonClassic) return false
        return name == other.name && age == other.age
    }


    override fun hashCode(): Int = 31 * name.hashCode() + age


    // Fonction copy manuelle
    fun copy(name: String = this.name, age: Int = this.age): PersonClassic =
        PersonClassic(name, age)
}