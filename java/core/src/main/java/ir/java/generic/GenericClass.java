package ir.java.generic;

/**
 * This class demonstrates the use of generics in Java.
 * It defines a generic class that can hold a value of any type.
 * Generics allow for type safety and code reusability.
 * its compile-time type checking ensures that the type of the value is consistent throughout the class.
 * This helps to prevent runtime errors that can occur when using raw types.
 * the generic type is not available at runtime due to type erasure, which means that the generic type information is not retained in the compiled bytecode.
 * However, the compiler uses this type information to enforce type safety during compilation.
 * This allows developers to write more flexible and reusable code while still maintaining type safety.
 * Generics are widely used in Java collections, such as List, Set, and Map,
 * where they allow for the creation of collections that can hold elements of a specific type.
 */
public class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        GenericClass<String> stringInstance = new GenericClass<>("Hello, Generics!");
        System.out.println(stringInstance);

        GenericClass<Integer> integerInstance = new GenericClass<>(42);
        System.out.println(integerInstance);
    }

}
