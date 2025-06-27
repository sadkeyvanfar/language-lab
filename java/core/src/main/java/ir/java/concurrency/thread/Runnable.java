package ir.java.concurrency.thread;

/**
 * This class demonstrates the creation and management of threads in Java.
 * It implements the Runnable interface and overrides the run method to define the thread's behavior.
 * this one is preferred over extending the Thread class.
 */
public class Runnable implements java.lang.Runnable {

    @Override
    public void run() {
        // Code that will be executed by this thread
        System.out.println("Runnable is running");
    }

    public static void main(String[] args) {
        java.lang.Thread thread = new java.lang.Thread(new Runnable());
        thread.start(); // Start the thread
    }

}
