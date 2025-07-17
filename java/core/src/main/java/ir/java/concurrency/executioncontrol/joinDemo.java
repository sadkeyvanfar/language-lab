package ir.java.concurrency.executioncontrol;

/**
 * Demonstrates the use of Thread.join() to wait for a thread to finish its
 * execution.
 * This is a simple example to illustrate how to use join in a thread.
 * The main thread will wait for the worker thread to complete before
 * continuing.
 */
public class joinDemo {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            System.out.println("Worker: Starting work...");
            try {
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Worker: Work completed.");
        });

        System.out.println("Main: Starting worker thread...");
        worker.start();

        try {
            worker.join(); // Main waits for worker to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main: Worker has finished. Continuing...");
    }
}
