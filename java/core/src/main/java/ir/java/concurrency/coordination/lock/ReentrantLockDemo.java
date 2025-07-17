package ir.java.concurrency.coordination.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * This class demonstrates the use of ReentrantLock for thread synchronization
 * in Java.
 * It provides methods to increment a count, ensuring that only one thread can
 * modify the count at a time.
 * ReentrantLock is explicit lock and allows for more flexible locking
 * mechanisms compared to synchronized blocks.
 */
public class ReentrantLockDemo {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock(); // explicit lock

    public void increment() {
        lock.lock(); // acquire the lock
        try {
            count++; // critical section
        } finally {
            lock.unlock(); // always release in finally block
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo counter = new ReentrantLockDemo();

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
