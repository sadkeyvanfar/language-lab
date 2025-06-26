package ir.java.basic;

// Define an interface named Animal
interface Animal {
    // Abstract method (does not have a body)
    void makeSound();

    // Default method (has a body)
    default void eat() {
        System.out.println("This animal eats food.");
    }
}

// Class Dog implements the Animal interface
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

// Class Cat implements the Animal interface
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

/**
 * This class demonstrates the use of interfaces in Java.
 * It includes an Animal interface with an abstract method and a default method,
 * and two classes (Dog and Cat) that implement the Animal interface.
 */
public class Interface {


    public static void main(String[] args) {
        // Create instances of Dog and Cat
        Animal dog = new Dog();
        Animal cat = new Cat();

        // Call the makeSound method
        dog.makeSound(); // Output: Woof!
        cat.makeSound(); // Output: Meow!

        // Call the eat method (default method)
        dog.eat(); // Output: This animal eats food.
        cat.eat(); // Output: This animal eats food.
    }
}
