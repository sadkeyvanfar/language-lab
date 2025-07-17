package ir.java.concurrency.lifecycle.cancellation;

/**
 * Demonstrates how to cancel a thread using interruption.
 * This example shows a worker thread that can be interrupted
 * to stop its execution cleanly.
 *
 * there is a interrupt flag in the thread that is checked
 * periodically to determine if the thread should stop.
 * If the thread is interrupted, it will exit its loop and finish execution.
 */
public class InterruptCancellationDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker: Started working...");
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // Simulate doing work
                    System.out.println("Worker: Working...");
                    Thread.sleep(500); // Sleep represents a blocking operation
                }
            } catch (InterruptedException e) {
                System.out.println("Worker: Interrupted during sleep.");
                // Exit on interrupt
            }
            System.out.println("Worker: Exiting cleanly.");
        });

        worker.start();

        // Let worker run for some time
        Thread.sleep(2000);

        System.out.println("Main: Interrupting worker to cancel...");
        worker.interrupt();

        worker.join();
        System.out.println("Main: Worker thread finished.");
    }
}
