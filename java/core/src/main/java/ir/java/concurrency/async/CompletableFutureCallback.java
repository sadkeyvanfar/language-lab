package ir.java.concurrency.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

// A simple example of using CompletableFuture with a callback mechanism
// to handle asynchronous operations in Java.
// This example simulates fetching data from a server, processing it, and handling errors.
// It demonstrates how to chain operations and handle exceptions in a clean way.
// its equivalent to using callback or Promise in JavaScript or other languages.
public class CompletableFutureCallback {

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
