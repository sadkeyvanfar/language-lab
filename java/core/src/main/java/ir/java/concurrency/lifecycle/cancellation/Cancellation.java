package ir.java.concurrency.lifecycle.cancellation;

/**
 * Demonstrates a simple cancellation mechanism using a volatile flag.
 * This example shows how to cancel a thread's execution gracefully
 * by checking a flag in the thread's run loop.
 */
public class Cancellation {
    private static volatile boolean running = true; // flag to control cancellation

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker: Started working...");

            while (running) {
                // Simulate doing work
                System.out.println("Worker: Working...");
                try {
                    Thread.sleep(500); // simulate blocking work
                } catch (InterruptedException e) {
                    // Ignore interrupts here, manual flag controls cancellation
                }
            }

            System.out.println("Worker: Detected cancel flag, exiting.");
        });

        worker.start();

        // Let the worker run for 2 seconds
        Thread.sleep(2000);

        System.out.println("Main: Setting running = false to cancel worker.");
        running = false; // signal the thread to stop

        worker.join();
        System.out.println("Main: Worker thread finished.");
    }
}
