package ir.java.concurrency.coordination.lock;

/*
 * This class demonstrates the use of implicit locking in Java.
 * The increment method is synchronized, which means it will lock the instance
 * of ImplicitLock when accessed by a thread, ensuring that only one thread can
 * execute it at a time.
 */
public class Synchronized {
    private int count = 0;

    public synchronized void increment() {
        count++; // critical section
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Synchronized counter = new Synchronized();

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
