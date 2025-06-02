package ir.kotlin.core

/**
 * This file demonstrates different ways to define functions in Kotlin.
 * It includes functions with block bodies, expression bodies, and type inference.
 * Note: Keep your return types explicit when writing a library
 */

// function with block body
fun maxByBlockBody(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// function with expression body
fun maxByExpressionBody(a: Int, b: Int): Int = if (a > b) a else b

// function with expression body and type inference
fun maxByExpressionBodyTypeInference(a: Int, b: Int) = if (a > b) a else b

fun main() {

    maxByBlockBody(3, 5).let { result ->
        println("The maximum value is: $result")
    }

    maxByExpressionBody(3, 5).let { result ->
        println("The maximum value is: $result")
    }

    maxByExpressionBodyTypeInference(3, 5).let { result ->
        println("The maximum value is: $result")
    }

}