package ir.java.exceptions;

public class CustomException {
    // Custom exception class can be defined here
    public static class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }

    // Example method that throws the custom exception
    public static void riskyMethod() throws MyCustomException {
        throw new MyCustomException("This is a custom exception message.");
    }

    public static void main(String[] args) {
        try {
            riskyMethod();
        } catch (MyCustomException e) {
            System.out.println("Caught a custom exception: " + e.getMessage());
        }
    }
}
