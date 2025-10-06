package com.solicode.kotlinessentiel.demo.collections

data class Todo(val id: Long, val title: String, val done: Boolean)
data class Section(val header: String, val items: List<Todo>)
data class Stats(val total: Int, val done: Int, val ratio: Double)

fun filterAndSort(todos: List<Todo>, q: String): List<Todo> =
    todos.filter { it.title.contains(q.trim(), ignoreCase = true) }
        .sortedBy { it.title.lowercase() }

fun asSections(todos: List<Todo>): List<Section> =
    todos.groupBy { if (it.done) "Done" else "To Do" }
        .map { (h, items) -> Section(h, items.sortedBy { it.title }) }

fun stats(todos: List<Todo>): Stats {
    val total = todos.size
    val done = todos.count { it.done }
    val ratio = if (total == 0) 0.0 else done.toDouble() / total
    return Stats(total, done, ratio)
}

fun main() {
    println("=== Step 1: Declare Collections ===")
    val tags: List<String> = listOf("android", "kotlin", "compose")  // immutable list
    val bag: MutableList<Int> = mutableListOf(1, 2, 2)              // mutable list
    val uniq: Set<String> = setOf("kotlin", "kotlin", "compose")    // unique elements
    val counts: MutableMap<String, Int> = mutableMapOf("done" to 3) // mutable map

    println("tags=$tags")
    println("bag before=$bag")
    bag.add(2)
    println("bag after=$bag")
    println("uniq=$uniq")
    println("counts=$counts\n")

    println("=== Step 2: Iterations ===")
    for (t in tags) println("tag=$t")                // simple iteration
    for ((i, t) in tags.withIndex()) println("$i → $t") // with index

    val mapExample = mapOf("done" to 3, "todo" to 5)
    for ((k, v) in mapExample) println("$k = $v")   // destructure map
    tags.forEach { println("• $it") }              // functional style
    println()

    println("=== Step 3: Transformations ===")
    val todos = listOf(
        Todo(1, "Study Kotlin", true),
        Todo(2, "Write UI Compose", false),
        Todo(3, "Tests", true),
        Todo(4, "Study Kotlin", false)
    )

    val doneTitles = todos.filter { it.done }.map { it.title }
    println("doneTitles=$doneTitles")

    val totalDone = todos.count { it.done }
    val totalChars = todos.sumOf { it.title.length }
    val avgTitle = todos.map { it.title.length }.average()
    println("done=$totalDone, chars=$totalChars, avg=$avgTitle")

    val sorted = todos.sortedBy { it.title.lowercase() }
    val distinctByTitle = todos.distinctBy { it.title }
    println("sorted=${sorted.map { it.title }}")
    println("distinctByTitle=${distinctByTitle.map { it.title }}")

    val byDone = todos.groupBy { it.done }
    val byId = todos.associateBy { it.id }
    println("byDone keys=${byDone.keys}")
    println("byId keys=${byId.keys}")

    val maybeIds: List<Long?> = listOf(1, null, 2)
    val ids = maybeIds.filterNotNull()
    println("ids=$ids")

    val kv = todos.associate { it.title to it.title.length }
    println("kv=$kv\n")

    println("=== Step 4: Map Safe Access ===")
    val m = mapOf("x" to 1)
    val v1 = m.getOrElse("y") { 0 }  // lazy default
    val v2 = m["y"] ?: 0             // constant default
    val v3 = m.getValue("x")         // throws if key missing
    println("v1=$v1, v2=$v2, v3=$v3")

    val pairs = listOf("a" to 1, "a" to 9, "b" to 2)
    val toMap = pairs.toMap()         // last value kept for duplicate keys
    println("toMap=$toMap")

    data class User(val id: Long, val name: String)
    val users = listOf(User(1, "Ali"), User(2, "Sara"), User(1, "Ali dup"))
    val byUserId = users.associateBy { it.id }
    println("byId=$byUserId\n")

    println("=== Step 5: Reusable Utilities ===")
    val filtered = filterAndSort(todos, "kotlin")
    println("filtered=${filtered.map { it.title }}")

    val sections = asSections(todos)
    println("sections=${sections.map { it.header to it.items.map { t -> t.title } }}")

    val st = stats(todos)
    println("stats=$st\n")

    println("=== Step 6: Performance Bonus ===")
    data class Blob(val size: Int, val id: Int)
    val blobs = (1..1000).map { Blob(it, it) }

    val firstBig1 = blobs.filter { it.size > 900 }.map { it.id }.firstOrNull()
    println("firstBig1=$firstBig1")

    val firstBig2 = blobs.asSequence().filter { it.size > 900 }.map { it.id }.firstOrNull()
    println("firstBig2=$firstBig2")
}
