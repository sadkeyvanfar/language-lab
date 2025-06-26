package ir.java.basic;

/**
 * This class demonstrates a simple Java class structure.
 * It includes an example field, a constructor, and getter/setter methods.
 */
public class Clazz {

    // Example field
    private String name;

    // Constructor
    public Clazz(String name) {
        this.name = name;
    }

    // Example method
    // getter method
    public String getName() {
        return name;
    }

    // setter method (mutator)
    public void setName(String name) {
        this.name = name;
    }

    // Main method for testing
    public static void main(String[] args) {
        Clazz example = new Clazz("Example Class");
        System.out.println("Class Name: " + example.getName());
    }
}
