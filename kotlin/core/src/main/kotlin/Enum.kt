package ir.kotlin.core

enum class Color(val r: Int, val g: Int, val b: Int) {
    BLUE(0, 0, 255),
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0); // the only place needs ;

    val rgb: Int = (r * 256 + g) * 256 + b

    fun printColor() = println("$this is $rgb")
}

fun main() {
    println(Color.YELLOW.rgb)
    Color.RED.printColor()
}
