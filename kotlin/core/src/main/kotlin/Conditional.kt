package ir.kotlin.core

import ir.kotlin.core.Color.*

// conditional are expressions in Kotlin
fun main() {
    /* if as an expression */
    // simple if expression
    val age = 18
    val canVote = if (age >= 18) "Can vote" else "Cannot vote"
    println(canVote)
    // if with multiple branches
    val score = 85
    val grade = if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else {
        "C"
    }
    println(grade)

    // $?: Elvis Operator (Null check shorthand)
    val name: String? = null
    val displayName = name ?: "Guest"
    println("Hello, $displayName")


    /* when */
    // when expression
    val color = "blue"
    val message = when (color) {
        "red" -> "Stop"
        "green" -> "Go"
        else -> "Caution"
    }
    println(message)

    // when With ranges and types
    val number = 5
    val result = when (number) {
        in 1..10 -> "Number is between 1 and 10"
        in 11..20 -> "Number is between 11 and 20"
        12 -> "Number is exactly 12"
        15, 16 -> "Number is either 15 or 16"
        !in 1..20 -> "Number is not in the range of 1 to 20"
        else -> "Number is out of range"
    }
    println(result)

    // when with enum classes
    val colorEnum = Color.RED
    val nameOfEnum = when(colorEnum) {
        RED, ORANGE, YELLOW -> "warm (red = ${colorEnum.r})"
        GREEN -> "neutral (green = ${colorEnum.g})"
        BLUE -> "cold (blue = ${colorEnum.b})"
    }
    println(nameOfEnum)

    // when With smart casting
    fun describe(x: Any) = when (x) {
        is String -> "It's a string of length ${x.length}"
        is Int -> "It's an integer"
        else -> "Unknown type"
    }

}