package ir.java.concurrency.thread;

import java.util.concurrent.FutureTask;
import java.lang.Thread;

public class Callable implements java.util.concurrent.Callable<String> {
    @Override
    public String call() {
        // Code that will be executed by this thread
        System.out.println("Callable is running");
        return "Done";
    }

    public static void main(String[] args) throws Exception {
        // Wrap Callable in a FutureTask
        FutureTask<String> futureTask = new FutureTask<>(new Callable());

        // Start the thread
        Thread thread = new Thread(futureTask);
        thread.start();

        // Wait for result
        String result = futureTask.get();
        System.out.println("Result from Callable: " + result);
    }
}
