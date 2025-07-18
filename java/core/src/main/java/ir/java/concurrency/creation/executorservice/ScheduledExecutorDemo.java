package ir.java.concurrency.creation.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrates the use of ScheduledExecutorService to schedule tasks
 * for execution after a delay or at fixed intervals.
 */
public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule a one-time task to run after 2 seconds
        scheduler.schedule(() -> {
            System.out.println("One-time task executed after 2 seconds delay");
        }, 2, TimeUnit.SECONDS);

        // Schedule a repeating task: initial delay 1 second, then every 3 seconds
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Repeating task executed at " + System.currentTimeMillis());
        }, 1, 3, TimeUnit.SECONDS);

        // Let the scheduler run tasks for 10 seconds, then shut down
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        scheduler.shutdown();
        System.out.println("Scheduler shut down");
    }
}
