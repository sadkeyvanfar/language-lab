package ir.java.concurrency.coordination.ThreadSafeCollections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Demonstrates the use of a CopyOnWriteArrayList for thread-safe collections
 * where reads are frequent and writes are rare.
 * The CopyOnWriteArrayList allows multiple threads to read concurrently
 * without blocking, while writes create a new copy of the list.
 * its based on copy-on-write strategy.
 */
public class CopyOnWriteArrayListDemo {
    private static final List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        // Pre-fill list
        for (int i = 1; i <= 5; i++) {
            list.add("Item-" + i);
        }

        // Writer thread (rarely writes)
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(2000); // initial delay before first write
                for (int i = 6; i <= 8; i++) {
                    list.add("Item-" + i);
                    System.out.println("Writer added: Item-" + i);
                    Thread.sleep(2000); // slow writes
                }
            } catch (InterruptedException ignored) {
            }
        });

        // Multiple reader threads (very frequent reads)
        Runnable readerTask = () -> {
            while (true) {
                // Iterate without synchronization, never blocks
                for (String item : list) {
                    System.out.print(Thread.currentThread().getName() + " reads " + item + " | ");
                }
                System.out.println();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        };

        // Start many readers
        for (int i = 1; i <= 5; i++) {
            new Thread(readerTask, "Reader-" + i).start();
        }

        writer.start();
        writer.join();
        System.out.println("Writer finished");
    }
}
