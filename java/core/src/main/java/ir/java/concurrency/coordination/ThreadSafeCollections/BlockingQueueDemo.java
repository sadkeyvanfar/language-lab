package ir.java.concurrency.coordination.ThreadSafeCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Demonstrates the use of a BlockingQueue for thread-safe communication
 * between a producer and a consumer.
 * The producer generates items and puts them into the queue,
 * while the consumer takes items from the queue.
 *
 * The BlockingQueue implementation ensures that the producer
 * will block if the queue is full, and the consumer will block
 * if the queue is empty.
 */
public class BlockingQueueDemo {
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String item = "Item-" + i;
                    queue.put(item); // blocks if full, backpressure effect
                    System.out.println("Produced: " + item);
                    Thread.sleep(500);
                }
                queue.put("END"); // signal termination
            } catch (InterruptedException ignored) {
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                String item;
                while (!(item = queue.take()).equals("END")) { // blocks if empty
                    System.out.println("Consumed: " + item);
                }
                System.out.println("Consumer done.");
            } catch (InterruptedException ignored) {
            }
        });

        producer.start();
        consumer.start();
    }
}
