package ir.java.concurrency.thread;

/**
 * This class demonstrates the creation and management of threads in Java.
 * It extends the Thread class and overrides the run method to define the thread's behavior.
 */
public class Thread extends java.lang.Thread {

    @Override
    public void run() {
        // Code that will be executed by this thread
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start(); // Start the thread
    }

}
