package ir.java.oop;

/**
 * Polymorphism in Java allows methods to be defined in a parent class and overridden in child classes.
 * This allows for dynamic method resolution at runtime, enabling a single interface to represent different underlying forms (data types).
*/


class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Drawing square");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.draw();
    }
}
