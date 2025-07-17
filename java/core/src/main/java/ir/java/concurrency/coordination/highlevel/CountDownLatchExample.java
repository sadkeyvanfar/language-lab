package ir.java.concurrency.coordination.highlevel;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final int WORKER_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(WORKER_COUNT);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " started working.");
            try {
                // Simulate some work
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " finished work.");
            latch.countDown(); // signal that this thread is done
        };

        Thread t1 = new Thread(worker, "Worker-1");
        Thread t2 = new Thread(worker, "Worker-2");

        t1.start();
        t2.start();

        System.out.println("Main thread waiting for workers to finish...");
        latch.await(); // wait until count reaches zero

        System.out.println("All workers finished. Main thread continues.");
    }
}
