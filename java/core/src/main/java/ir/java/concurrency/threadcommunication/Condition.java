package ir.java.concurrency.threadcommunication;

/**
 * This class demonstrates the use of Condition for thread communication.
 * It contains two threads: one that waits for a condition to be met and another
 * that notifies the waiting thread when the condition is set.
 */
public class Condition {
    private static final Object lock = new Object();
    private static boolean conditionMet = false;

    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                while (!conditionMet) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Condition met, proceeding with the task.");
            }
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                conditionMet = true;
                lock.notify();
                System.out.println("Condition set, notified waiting thread.");
            }
        });

        waitingThread.start();
        notifyingThread.start();
    }
}
