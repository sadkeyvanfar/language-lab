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

    // Capturing the subject of a when expression in a variable
    fun measureColor() = Color.ORANGE
    fun getWarmthFromSensor() =
    when (val colorMine = measureColor()) {
        RED, ORANGE, YELLOW -> "warm (red = ${colorMine.r})"
        GREEN -> "neutral (green = ${colorMine.g})"
        BLUE -> "cold (blue = ${colorMine.b}"
    }
    
    // with arbitrary objects
    fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        else -> throw Exception("Dirty color")
    }
    println(mix(BLUE, YELLOW))

    // Using the when expression without an argument (efficient)
    fun mixOptimized(c1: Color, c2: Color) =
    when { // when without argument
        (c1 == RED && c2 == YELLOW) ||
        (c1 == YELLOW && c2 == RED) ->
            ORANGE
 
        (c1 == YELLOW && c2 == BLUE) ||
        (c1 == BLUE && c2 == YELLOW) ->
            GREEN
 
        (c1 == BLUE || c2 == BLUE) ->
            BLUE
 
        else -> throw Exception("Dirty color")
    }

    // when With smart casting
    fun describe(x: Any) = when (x) {
        is String -> "It's a string of length ${x.length}"
        is Int -> "It's an integer"
        else -> "Unknown type"
    }

}