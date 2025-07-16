package ir.java.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLock {
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
        ExplicitLock counter = new ExplicitLock();

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
