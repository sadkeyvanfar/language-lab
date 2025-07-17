package ir.java.concurrency.coordination.lock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A simple implementation of a spin lock using AtomicBoolean.
 * This lock allows threads to acquire and release a lock in a busy-wait manner.
 */
public class SpinLock {

    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        while (!lock.compareAndSet(false, true)) {
            // busy-wait (spin)
            Thread.yield(); // optional: give CPU to other threads (still spinning, just less aggressively)
        }
    }

    public void unlock() {
        lock.set(false);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " trying to acquire lock...");
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock.");
                try {
                    Thread.sleep(500); // simulate some work
                } catch (InterruptedException ignored) {
                }
            } finally {
                spinLock.unlock();
                System.out.println(Thread.currentThread().getName() + " released lock.");
            }
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");

        t1.start();
        t2.start();
    }
}
