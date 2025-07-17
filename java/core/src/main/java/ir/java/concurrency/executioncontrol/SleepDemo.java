package ir.java.concurrency.executioncontrol;

/**
 * Demonstrates the use of Thread.sleep() for pausing the execution of the main
 * thread.
 * This is a simple example to illustrate how to use sleep in a thread.
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        // Simulate some work
        try {
            System.out.println("Main thread sleeping for 2 seconds");
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Main thread finished");
    }
}
