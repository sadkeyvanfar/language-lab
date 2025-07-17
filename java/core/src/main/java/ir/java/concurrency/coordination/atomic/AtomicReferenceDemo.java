package ir.java.concurrency.coordination.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * This class demonstrates the use of AtomicReference for thread-safe
 * updates to an object reference.
 * It provides methods to update a person's name and retrieve the current
 * person.
 * Its lock-free nature allows multiple threads to update the reference
 * concurrently without the need for explicit synchronization.
 */
public class AtomicReferenceDemo {
    static class Person {
        final String name;

        Person(String name) {
            this.name = name;
        }

        public String toString() {
            return "Person(" + name + ")";
        }
    }

    private final AtomicReference<Person> personRef = new AtomicReference<>(new Person("Alice"));

    public void updatePerson(String newName) {
        Person oldPerson;
        Person newPerson;
        do {
            oldPerson = personRef.get();
            newPerson = new Person(newName);
            // Try to atomically update reference if it still points to oldPerson
        } while (!personRef.compareAndSet(oldPerson, newPerson));
        System.out.println("Updated from " + oldPerson + " to " + newPerson);
    }

    public Person getPerson() {
        return personRef.get();
    }

    public static void main(String[] args) {
        AtomicReferenceDemo example = new AtomicReferenceDemo();

        System.out.println("Initial: " + example.getPerson());

        example.updatePerson("Bob");
        example.updatePerson("Carol");

        System.out.println("Final: " + example.getPerson());
    }
}
