package ir.kotlin.core

// shows how to use string templates in Kotlin
fun main() {
    println("Please enter your name:")
    val name = readln()
    println("Hello, ${if (name.isBlank()) "someone" else name}!")
}