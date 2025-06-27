package ir.java.exceptions;

/**
 * This class demonstrates the use of try-catch blocks in Java for exception handling.
 * It includes examples of catching specific exceptions and using a try-with-resources statement.
 */
public class TryCatch {

    public static void main(String[] args) {
        try {
            // Code that may throw an exception
            int result = 10 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle the exception
            System.out.println("Caught an arithmetic exception: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            // This block always executes
            System.out.println("Finally block executed.");
        }
        // Example of a try-with-resources block
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (java.io.IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
