package ir.java.concurrency.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates the use of CompletableFuture for asynchronous programming in
 * Java. based on callback mechanism
 * This example fetches data asynchronously, processes it, and handles any
 * potential errors.
 * It demonstrates how to chain operations and handle exceptions in a clean way.
 * its equivalent to using callback or Promise in JavaScript or other languages.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            // Simulate fetching data
            System.out.println("📡 Fetching data from server...");
            sleep(1000); // simulate delay
            return "raw server data";
        }).thenApply(data -> {
            // Simulate processing data
            System.out.println("Processing data...");
            return data.toUpperCase(); // or more complex transformation
        }).thenAccept(result -> {
            // Final step
            System.out.println("Final result: " + result);
        }).exceptionally(ex -> {
            // Error handling
            System.err.println("Error: " + ex.getMessage());
            return null;
        });

        // Keep main thread alive to see async output
        sleep(2000);
    }

    // Utility sleep method
    private static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
