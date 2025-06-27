package ir.java.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class demonstrates various collection operations in Java.
 * It includes examples of using lists, sets, maps, and other collection types.
 */
public class Collections {
    public static void main(String[] args) {

        // You can create instances of different collections and perform operations on them.
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println("List contents: " + list);

        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Java");
        System.out.println("Set contents: " + set);

        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println("Map contents: " + map);

        // You can also demonstrate operations like sorting, filtering, and iterating over collections.
        java.util.Collections.sort(list);
        System.out.println("Sorted list contents: " + list);
        for (String item : set) {
            System.out.println("Set item: " + item);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Map entry: " + entry.getKey() + " = " + entry.getValue());
        }

        // Example of using streams to filter and collect items from a collection
        List<String> filteredList = list.stream()
                .filter(s -> s.startsWith("H"))
                .collect(Collectors.toList());
        System.out.println("Filtered list (starts with 'H'): " + filteredList);
    }
}
