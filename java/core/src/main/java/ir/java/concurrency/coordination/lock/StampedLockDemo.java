package ir.java.concurrency.coordination.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * This class demonstrates the use of StampedLock in Java.
 * It allows multiple threads to read a shared resource concurrently,
 * while ensuring exclusive access for writing.
 * It also supports optimistic reading, which can be more efficient in certain
 * scenarios.
 * StampedLock is a more flexible alternative to ReentrantReadWriteLock.
 * It provides a way to perform optimistic reads, which can reduce contention
 * when reads are frequent and writes are infrequent.
 */
public class StampedLockDemo {
    private int count = 0;
    private final StampedLock lock = new StampedLock();

    // Exclusive write
    public void increment() {
        long stamp = lock.writeLock();
        try {
            count++;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    // Shared read
    public int read() {
        long stamp = lock.readLock();
        try {
            return count;
        } finally {
            lock.unlockRead(stamp);
        }
    }

    // Optimistic read
    public int optimisticRead() {
        long stamp = lock.tryOptimisticRead();
        int current = count;
        if (!lock.validate(stamp)) {
            // fallback to read lock
            stamp = lock.readLock();
            try {
                current = count;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return current;
    }

    public static void main(String[] args) {
        StampedLockDemo counter = new StampedLockDemo();

        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }, "Writer");

        // Reader thread using optimistic read
        Thread optimisticReader = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int val = counter.optimisticRead();
                System.out.println(Thread.currentThread().getName() + " optimistic read: " + val);
                try {
                    Thread.sleep(80);
                } catch (InterruptedException ignored) {
                }
            }
        }, "OptimisticReader");

        // Reader thread using normal read lock
        Thread safeReader = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int val = counter.read();
                System.out.println(Thread.currentThread().getName() + " safe read: " + val);
                try {
                    Thread.sleep(90);
                } catch (InterruptedException ignored) {
                }
            }
        }, "SafeReader");

        writer.start();
        optimisticReader.start();
        safeReader.start();
    }
}
