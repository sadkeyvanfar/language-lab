package ir.java.concurrency.lifecycle;

import java.lang.Thread;

/**
 * This class demonstrates the creation and management of threads in Java.
 * It extends the Thread class and overrides the run method to define the
 * thread's behavior.
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        // Code that will be executed by this thread
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        thread.start(); // Start the thread
    }

}
