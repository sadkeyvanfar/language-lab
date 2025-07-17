package ir.java.concurrency.coordination.highlevel;

import java.util.concurrent.Exchanger;

/**
 * This class demonstrates the use of Exchanger in Java.
 * It creates multiple threads that perform some work and then exchange messages
 * with each other at an exchange point.
 * It creates multiple threads that exchange messages with each other.
 */
public class ExchangerDemo {

    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        // Example usage of Exchanger
        Exchanger<String> exchanger = new Exchanger<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    String message = "Message from thread " + threadId;
                    System.out.println("Thread " + threadId + " is exchanging message: " + message);
                    String receivedMessage = exchanger.exchange(message);
                    System.out.println("Thread " + threadId + " received message: " + receivedMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
