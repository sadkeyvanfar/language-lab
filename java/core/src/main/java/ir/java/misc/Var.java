package ir.java.misc;

/**
 * This class demonstrates the use of 'var' for type inference in Java.
 * It includes examples of using 'var' with different data types and collections.
 */
public class Var {

    public static void main(String[] args) {
        // Using 'var' for type inference
        var message = "Hello, World!";
        System.out.println(message);

        // Using 'var' with a collection
        var numbers = new int[]{1, 2, 3, 4, 5};
        for (var number : numbers) {
            System.out.println(number);
        }
    }
}
