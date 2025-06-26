package ir.java.basic;

/**
 * This class demonstrates the use of primitive and non-primitive data types in Java.
 * It includes examples of byte, short, int, long, float, double, char, boolean,
 * String, and array data types.
 */
public class DataType {
    public static void main(String[] args) {
        // Primitive Data Types
        byte smallNumber = 100; // Byte type
        short mediumNumber = 10000; // Short type
        int integer = 42; // Integer type
        long largeNumber = 100000L; // Long type

        float floatingPoint = 3.14f; // Float type
        double decimal = 3.14; // Floating-point type

        char character = 'A'; // Character type

        boolean flag = true; // Boolean type

        // Non-Primitive Data Types
        String text = "Hello, World!"; // String type
        int[] numbers = {1, 2, 3, 4, 5}; // Array type

        // Displaying the values
        System.out.println("Byte: " + smallNumber);
        System.out.println("Short: " + mediumNumber);
        System.out.println("Integer: " + integer);
        System.out.println("Long: " + largeNumber);
        System.out.println("Float: " + floatingPoint);
        System.out.println("Decimal: " + decimal);
        System.out.println("Character: " + character);
        System.out.println("Boolean: " + flag);
        System.out.println("String: " + text);
        System.out.print("Array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
