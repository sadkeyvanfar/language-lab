package ir.kotlin.core

// define a class named `Person` with a single property `name` of type `String`
class Person(val name: String, var age: Int) {
    // Custom accessors
    val isAdult: Boolean
        get() = age >= 18

    fun greet() = println("Hello, my name is $name and I am $age years old. Is adult: $isAdult")
    
    // needs toString method to print the object in a readable format
    override fun toString(): String {
        return "Person(name='$name', age=$age, isAdult=$isAdult)"
    }
}

fun main() {
    // create an instance of `Person` with a name and age without using `new`
    val person = Person("Alice", 16)
    person.greet()
    
    person.age = 31
    person.greet()
    println("Is adult: ${person}")
}