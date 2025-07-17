package ir.java.concurrency.coordination.highlevel;

import java.util.concurrent.CyclicBarrier;

/**
 * This class demonstrates the use of CyclicBarrier in Java.
 * It creates multiple threads that perform some work and then wait at a barrier
 * until all threads have reached the barrier before proceeding.
 */
public class CyclicBarrierDemo {

    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        // Example usage of CyclicBarrier
        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
            System.out.println("All threads have reached the barrier, proceeding with the next step.");
        });

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            new Thread(() -> {
                System.out.println("Thread " + threadId + " is doing some work...");
                try {
                    System.out.println("Thread " + threadId + " is doing some work.");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println("Thread " + threadId + " has reached the barrier.");
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
