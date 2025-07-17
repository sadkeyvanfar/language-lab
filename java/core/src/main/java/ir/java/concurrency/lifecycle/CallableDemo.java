package ir.java.concurrency.lifecycle;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.lang.Thread;

/**
 * A simple example of using Callable in Java.
 * This class implements Callable and overrides the call method.
 * The call method contains the code that will be executed by the thread.
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() {
        // Code that will be executed by this thread
        System.out.println("Callable is running");
        return "Done";
    }

    public static void main(String[] args) throws Exception {
        // Wrap Callable in a FutureTask
        FutureTask<String> futureTask = new FutureTask<>(new CallableDemo());

        // Start the thread
        Thread thread = new Thread(futureTask);
        thread.start();

        // Wait for result
        String result = futureTask.get();
        System.out.println("Result from Callable: " + result);
    }
}
