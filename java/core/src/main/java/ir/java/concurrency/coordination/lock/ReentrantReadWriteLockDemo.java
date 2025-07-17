package ir.java.concurrency.coordination.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class demonstrates the use of ReentrantReadWriteLock in Java.
 * It allows multiple threads to read a shared resource concurrently,
 * while ensuring exclusive access for writing.
 */
public class ReentrantReadWriteLockDemo {

    private int count = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
        } finally {
            writeLock.unlock();
        }
    }

    public void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " read count: " + count);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo example = new ReentrantReadWriteLockDemo();

        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }, "Writer");

        // Reader threads
        Runnable readerTask = () -> {
            for (int i = 0; i < 5; i++) {
                example.read();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {
                }
            }
        };

        Thread reader1 = new Thread(readerTask, "Reader-1");
        Thread reader2 = new Thread(readerTask, "Reader-2");

        // Start all threads
        writer.start();
        reader1.start();
        reader2.start();
    }
}
