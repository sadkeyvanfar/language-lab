package ir.java.misc;

public class SimpleEnum {
    // Example of an enum in Java
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        // Using the enum
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);

        // Looping through the enum values
        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }
}
