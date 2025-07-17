package ir.java.concurrency.coordination.visibility;

/**
 * This class demonstrates the use of the volatile keyword in Java.
 * It shows how a volatile variable ensures visibility of changes across
 * threads.
 * The watcher thread waits for a flag to become true, while the setter
 * thread sets the flag after a delay.
 * synchronized blocks are visible to all threads, but volatile
 * variables are also visible without needing to synchronize.
 */
public class VolatileDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread watcher = new Thread(() -> {
            System.out.println("Watcher: Waiting for flag to become true...");
            while (!flag) {
                // Busy wait
            }
            System.out.println("Watcher: Flag is true!");
        });

        Thread setter = new Thread(() -> {
            try {
                Thread.sleep(1000); // simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            flag = true;
            System.out.println("Setter: Flag set to true");
        });

        watcher.start();
        setter.start();
    }
}
