package ir.java.concurrency.coordination.highlevel;

import java.util.concurrent.Semaphore;

/**
 * This class demonstrates the use of a Semaphore to control
 * access to a shared resource.
 * The increment method uses a Semaphore to ensure that only one thread
 * can increment the count at a time, similar to a mutex.
 */

public class SemaphoreCounter {
    private int count = 0;
    private final Semaphore semaphore = new Semaphore(3); // if it was 1 = Binary semaphore = mutex

    public void increment() {
        try {
            semaphore.acquire();
            count++; // critical section
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    public int getCount() {
        try {
            semaphore.acquire();
            return count;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreCounter counter = new SemaphoreCounter();

        // Create 2 threads that increment the counter 1000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
