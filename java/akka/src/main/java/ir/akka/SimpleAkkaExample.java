package ir.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class SimpleAkkaExample {

    // Actor defined inside the same file
    static class MyActor extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, msg -> {
                        System.out.println("Received message: " + msg);
                    })
                    .build();
        }
    }

    // Main method - entry point for this example
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("SimpleSystem");

        ActorRef actor = system.actorOf(Props.create(MyActor.class), "myActor");

        actor.tell("Hello from SimpleAkkaExample", ActorRef.noSender());

        // Wait a bit before shutting down to allow message processing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        system.terminate();
    }
}
