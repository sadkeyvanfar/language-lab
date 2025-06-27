package ir.java.functional;

import java.util.function.Consumer;

/**
 * This class demonstrates the use of lambda expressions in Java.
 * It includes examples of functional interfaces and method references.
 */
public class Function {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        // Example of a lambda expression
        Runnable runnable = () -> System.out.println("Hello from a lambda expression!");
        runnable.run();

        // Example of a method reference
        Function lambda = new Function();
        Runnable methodRef = lambda::printMessage;
        methodRef.run();

        // Example of a static method reference
        Consumer<String> staticMethodRef = Function::print;
        staticMethodRef.accept("Hello from a static method reference!");
    }

    public void printMessage() {
        System.out.println("Hello from a method reference!");
    }
}
