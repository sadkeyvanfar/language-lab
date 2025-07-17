package ir.java.concurrency.thread;

import java.lang.Thread;

/**
 * This class demonstrates the creation and management of threads in Java.
 * It implements the Runnable interface and overrides the run method to define
 * the thread's behavior.
 * this one is preferred over extending the Thread class.
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        // Code that will be executed by this thread
        System.out.println("Runnable is running");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start(); // Start the thread
    }

}
