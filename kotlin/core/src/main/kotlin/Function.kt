package ir.kotlin.core

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