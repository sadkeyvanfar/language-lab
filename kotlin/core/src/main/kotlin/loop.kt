
fun main() {
    /* for */
    // Using `for` loop in Kotlin
    for (i in 1..5) {
        println("Iteration $i")
    }
    // Using `for` with ranges
    for (i in 1 until 5) {
        println("Iteration $i")
    }
    // Using `for` with step
    for (i in 1..10 step 2) {
        println("Step iteration $i")
    }
    // Using `for` with downTo
    for (i in 5 downTo 1) {
        println("Down iteration $i")
    }
    // Using `for` with indices
    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println("Element at index $i is ${array[i]}")
    }
    // Using `for` with destructuring declarations
    val pairs = listOf(Pair("a", 1), Pair("b", 2), Pair("c", 3))
    for ((letter, number) in pairs) {
        println("Letter: $letter, Number: $number")
    }
    // Using `for` with collections
    val list = listOf("apple", "banana", "cherry")
    for (fruit in list) {
        println("Fruit: $fruit")
    }
    // Using `for` with maps
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((key, value) in map) {
        println("Key: $key, Value: $value")
    }
    
    /* while */
    // Using `while` loop
    while (true) {
        println("This is an infinite loop")
        break // to prevent actual infinite loop in this example
    }
    // Using `while` loop
    var count = 0
    while (count < 5) {
        println("Count is $count")
        count++
    }

    /* Using `do while` loop */
    var index = 0
    do {
        println("Index is $index")
        index++
    } while (index < 5)

    // Using `repeat` function
    repeat(3) {
        println("This is iteration number $it")
    }
}