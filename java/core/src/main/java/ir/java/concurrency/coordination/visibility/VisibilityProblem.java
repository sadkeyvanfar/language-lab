package ir.java.concurrency.coordination.visibility;

/**
 * This class demonstrates a visibility problem in Java concurrency.
 * It shows how changes made by one thread may not be visible to another
 * thread immediately due to caching and compiler optimizations.
 * The watcher thread waits for a flag to become true, while the setter
 * thread sets the flag after a delay.
 */
public class VisibilityProblem {
    private static boolean flag = false;

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
