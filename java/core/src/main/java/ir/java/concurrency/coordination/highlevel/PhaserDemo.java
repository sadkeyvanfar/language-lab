package ir.java.concurrency.coordination.highlevel;

import java.util.concurrent.Phaser;

/**
 * This class demonstrates the use of Phaser in Java.
 * Phaser is a synchronization aid that allows a set of threads to wait for each
 * other
 * to reach a common barrier point.
 * It is useful for coordinating phases of execution in concurrent applications.
 * Phaser can be used to manage multiple phases of execution,
 * where each phase can have a different number of participants.
 * It is more flexible than CountDownLatch or CyclicBarrier,
 * as it allows dynamic registration and deregistration of threads.
 * Threads can also arrive at different times and still participate in the same
 * phase.
 */
public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // 3 parties (threads)

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " doing phase 0");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " doing phase 1");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " finished");
        };

        new Thread(task, "Thread A").start();
        new Thread(task, "Thread B").start();
        new Thread(task, "Thread C").start();
    }
}
