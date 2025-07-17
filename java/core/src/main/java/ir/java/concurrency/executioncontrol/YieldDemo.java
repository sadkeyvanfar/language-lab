package ir.java.concurrency.executioncontrol;

/**
 * Demonstrates the use of Thread.yield() to hint the thread scheduler
 * that the current thread is willing to yield its current use of the CPU.
 * This is a simple example to illustrate how to use yield in a thread.
 * Yielding does not guarantee that the thread will be paused,
 * but it suggests to the thread scheduler that it can switch to another thread.
 * points to note:
 * 1. Yielding is a hint to the thread scheduler, not a command.
 * 2. The thread may not yield immediately, depending on the scheduler's
 * implementation.
 * 3. yielding doesn't mean thread goes to sleep, it just gives up the CPU for
 * other threads. (its runnable state)
 */
public class YieldDemo {
    public static void main(String[] args) {
        Thread yieldingThread = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("YieldingThread - iteration " + i);
                Thread.yield(); // Hint to give up CPU
            }
        });

        Thread nonYieldingThread = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println("NonYieldingThread - iteration " + i);
                // No yield
            }
        });

        yieldingThread.start();
        nonYieldingThread.start();
    }
}
