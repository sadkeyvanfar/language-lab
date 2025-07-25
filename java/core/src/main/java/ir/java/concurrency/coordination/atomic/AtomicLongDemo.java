package ir.java.concurrency.coordination.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class demonstrates the use of AtomicLong for thread-safe
 * incrementing of a counter.
 * It provides methods to increment the counter and retrieve its value.
 * its lock-free nature allows multiple threads to increment the counter
 * concurrently without the need for explicit synchronization.
 */
public class AtomicLongDemo {
    private final AtomicLong counter = new AtomicLong(0);

    public void increment() {
        // i++ is not atomic, so we use AtomicInteger's incrementAndGet method
        counter.incrementAndGet(); // atomic and visible increment
    }

    public long getValue() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicLongDemo example = new AtomicLongDemo();

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
