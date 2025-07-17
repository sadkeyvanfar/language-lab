package ir.java.concurrency.coordination.condition;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BufferByCondition {
    private int item;
    private boolean hasItem = false;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition(); // only one condition

    public void put(int value) throws InterruptedException {
        lock.lock();
        try {
            while (hasItem) {
                condition.await(); // wait until buffer is empty
            }
            item = value;
            hasItem = true;
            System.out.println("Produced: " + value);
            condition.signal(); // notify consumer
        } finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try {
            while (!hasItem) {
                condition.await(); // wait until buffer is full
            }
            hasItem = false;
            System.out.println("Consumed: " + item);
            condition.signal(); // notify producer
            return item;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BufferByCondition buffer = new BufferByCondition();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    buffer.put(i);
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    buffer.get();
                    Thread.sleep(150);
                } catch (InterruptedException ignored) {
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
