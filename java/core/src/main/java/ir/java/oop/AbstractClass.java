package ir.java.oop;

abstract class Vehicle {
    abstract void start();
}

/**
 * This class demonstrates the use of abstract classes in Java.
 * It includes an abstract class Vehicle with an abstract method start,
 * and a subclass Car that implements the start method.
 */
class Car extends Vehicle {
    void start() {
        System.out.println("Car starting");
    }

    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
    }
}
