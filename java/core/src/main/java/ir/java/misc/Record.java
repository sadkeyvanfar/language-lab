package ir.java.misc;

/**
 * This class demonstrates the use of records in Java.
 * Records are a special kind of class in Java that are used to model immutable data.
 * A Java record provides shallow immutability.
 * Records automatically generate methods like equals(), hashCode(), and toString(),
 * making them useful for data transfer objects (DTOs) and simple data structures.
 */
public class Record {
    // Example of a record in Java
    public record Person(String name, int age) {
        // Constructor is automatically generated
        // Getters are also automatically generated
    }

    public static void main(String[] args) {
        // Creating an instance of the record
        Person person = new Person("Alice", 30);

        // Accessing the fields
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
    }
}
