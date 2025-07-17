package ir.java.concurrency.cordination.lock;

/*
 * This class demonstrates the use of explicit locking in Java using a synchronized block.
 * The increment method uses a synchronized block to ensure that only one thread can
 * execute it at a time, while allowing more flexibility in locking.
 */
public class SynchronizedBlock {
    private int count = 0;
    private final Object lock = new Object(); // the lock object

    public void increment() {
        synchronized (lock) {
            count++; // critical section
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlock counter = new SynchronizedBlock();

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
