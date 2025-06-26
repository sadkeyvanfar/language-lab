package ir.java.oop;

/**
 * This class demonstrates the use of inheritance in Java.
 * It includes a base class Animal and a derived class Dog that inherits from Animal.
 * multiple inheritance is not supported in Java, but a class can implement multiple interfaces.
 */
public class Inheritance {

    // Example of inheritance in Java:
    class Animal {
        void eat() {
            System.out.println("This animal eats food.");
        }
    }

    class Dog extends Animal {
        void bark() {
            System.out.println("The dog barks.");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Inheritance().new Dog();
        dog.eat(); // Inherited method
        dog.bark(); // Dog's own method
    }

}
