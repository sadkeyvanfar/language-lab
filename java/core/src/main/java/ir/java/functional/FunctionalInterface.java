package ir.java.functional;

/**
 * This is a functional interface with a single abstract method.
 * It can be used as the assignment target for a lambda expression or method reference.
 */
public class FunctionalInterface {

    @java.lang.FunctionalInterface
    public interface MyFunctionalInterface {
        void execute(String message);
    }

    public static void main(String[] args) {
        // Using a lambda expression to implement the functional interface
        MyFunctionalInterface myFunc = (message) -> System.out.println("Message: " + message);
        myFunc.execute("Hello, Functional Interface!");
    }
}
