package ir.java.concurrency.coordination.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {
    private final AtomicIntegerArray arr;

    public AtomicIntegerArrayDemo(int length) {
        arr = new AtomicIntegerArray(length);
    }

    // Atomically increment element at index i
    public void increment(int i) {
        arr.incrementAndGet(i);
    }

    // Get current value at index i
    public int get(int i) {
        return arr.get(i);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArrayDemo demo = new AtomicIntegerArrayDemo(5);

        // Create threads that increment elements concurrently
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment(0);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment(1);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Element 0: " + demo.get(0)); // Should be 1000
        System.out.println("Element 1: " + demo.get(1)); // Should be 1000
    }
}
