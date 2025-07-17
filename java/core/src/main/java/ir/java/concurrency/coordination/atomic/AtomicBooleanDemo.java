package ir.java.concurrency.coordination.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class demonstrates the use of AtomicBoolean for thread-safe
 * flag setting and checking.
 * It provides methods to set a flag and check its status in a multi-threaded
 * environment.
 */
public class AtomicBooleanDemo {
    private static final AtomicBoolean flag = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread setter = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                flag.set(true);
                System.out.println("Setter: flag set to true");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread watcher = new Thread(() -> {
            while (true) {
                // compareAndSet checks if the current value is true and sets it to false if it
                // is and is atomic and visible to all threads
                if (flag.compareAndSet(true, false)) {
                    System.out.println("Watcher: detected and reset flag");
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        setter.start();
        watcher.start();
    }
}
