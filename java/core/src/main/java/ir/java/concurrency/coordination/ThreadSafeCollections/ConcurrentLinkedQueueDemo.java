package ir.java.concurrency.coordination.ThreadSafeCollections;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Demonstrates the use of a ConcurrentLinkedQueue for thread-safe communication
 * between a producer and a consumer.
 * The producer generates items and adds them to the queue,
 * while the consumer takes items from the queue.
 *
 * The ConcurrentLinkedQueue implementation allows non-blocking operations,
 * meaning the producer will not block if the queue is full,
 * and the consumer will not block if the queue is empty.
 */
public class ConcurrentLinkedQueueDemo {
    private static final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                String item = "Item-" + i;
                queue.add(item); // non-blocking
                System.out.println("Produced: " + item);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            while (true) {
                String item = queue.poll(); // non-blocking
                if (item != null) {
                    System.out.println("Consumed: " + item);
                    if (item.equals("Item-5"))
                        break;
                } else {
                    // No item available yet
                    try {
                        Thread.sleep(100); // avoid busy wait, backoff strategy
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
