package ir.java.concurrency.creation.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates the use of ExecutorService to manage a pool of
 * threads
 * for executing tasks concurrently. It submits multiple tasks to the executor
 * and manages their execution.
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
