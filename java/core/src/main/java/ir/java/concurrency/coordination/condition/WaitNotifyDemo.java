package ir.java.concurrency.coordination.condition;

/**
 * This class demonstrates the use of wait and notify for thread coordination in
 * Java.
 * It provides methods to put and get items, ensuring that the producer waits
 * when the buffer is full
 * and the consumer waits when the buffer is empty.
 */
public class WaitNotifyDemo {
    private int item;
    private boolean hasItem = false;

    public synchronized void put(int value) throws InterruptedException {
        while (hasItem) {
            wait(); // wait until buffer is empty
        }
        item = value;
        hasItem = true;
        System.out.println("Produced: " + value);
        notify(); // notify consumer
    }

    public synchronized int get() throws InterruptedException {
        while (!hasItem) {
            wait(); // wait until buffer is full
        }
        hasItem = false;
        System.out.println("Consumed: " + item);
        notify(); // notify producer
        return item;
    }

    public static void main(String[] args) {
        WaitNotifyDemo buffer = new WaitNotifyDemo();

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
