package ir.java.generic;

/**
 * This class demonstrates the use of a generic method in Java.
 * A generic method can operate on objects of various types while providing type safety.
 */
public class GenericMethod {

    /**
     * This method demonstrates a generic method that can accept any type of object.
     * It prints the class name of the object passed to it.
     *
     * @param obj The object whose class name will be printed.
     * @param <T> The type of the object.
     */
    public static <T> void printClassName(T obj) {
        System.out.println("The class of the object is: " + obj.getClass().getName());
    }

    public static void main(String[] args) {
        // Example usage of the generic method
        printClassName("Hello, World!"); // String
        printClassName(123); // Integer
        printClassName(45.67); // Double
    }
}
