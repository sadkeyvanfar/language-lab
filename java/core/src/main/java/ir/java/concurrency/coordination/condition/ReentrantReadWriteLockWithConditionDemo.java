package ir.java.concurrency.coordination.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockWithConditionDemo {
    private int count = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private final Condition notZero = writeLock.newCondition();

    public void increment() {
        writeLock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
            notZero.signalAll(); // wake up waiting readers
        } finally {
            writeLock.unlock();
        }
    }

    public void read() {
        // First, use writeLock to check the condition safely
        writeLock.lock();
        try {
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting for count to be non-zero...");
                notZero.await();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        } finally {
            writeLock.unlock();
        }

        // Now safely acquire readLock to read
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " read count: " + count);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockWithConditionDemo example = new ReentrantReadWriteLockWithConditionDemo();

        // Writer thread
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(500); // delay so readers wait initially
            } catch (InterruptedException ignored) {
            }

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
                    Thread.sleep(80);
                } catch (InterruptedException ignored) {
                }
            }
        };

        Thread reader1 = new Thread(readerTask, "Reader-1");
        Thread reader2 = new Thread(readerTask, "Reader-2");

        // Start all threads
        reader1.start();
        reader2.start();
        writer.start();
    }
}
