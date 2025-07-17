package ir.java.concurrency.coordination.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class demonstrates the use of AtomicInteger for thread-safe
 * incrementing of a counter.
 * It provides methods to increment the counter and retrieve its value.
 * its lock-free nature allows multiple threads to increment the counter
 * concurrently without the need for explicit synchronization.
 */
public class AtomicIntegerDemo {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        // i++ is not atomic, so we use AtomicInteger's incrementAndGet method
        counter.incrementAndGet(); // atomic and visible increment
    }

    public int getValue() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo example = new AtomicIntegerDemo();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + example.getValue()); // Should be 2000
    }
}
