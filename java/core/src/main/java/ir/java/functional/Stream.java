package ir.java.functional;

/**
 * This class demonstrates the creation and use of streams in Java.
 * It includes examples of filtering and processing elements in a stream.
 */
public class Stream {
    public static void main(String[] args) {
        // Example of creating a stream from a collection
        java.util.List<String> list = java.util.Arrays.asList("apple", "banana", "cherry");
        list.stream()
            .filter(s -> s.startsWith("a"))
            .forEach(System.out::println);

        // Example of creating a stream from an array
        String[] array = {"dog", "cat", "elephant"};
        java.util.Arrays.stream(array)
            .filter(s -> s.length() > 3)
            .forEach(System.out::println);

        // Example of using a stream to perform a reduction operation
        int sum = java.util.Arrays.stream(new int[]{1, 2, 3, 4, 5})
            .sum();
        System.out.println("Sum: " + sum);

        // Example of using a stream to collect results into a list
        java.util.List<String> filteredList = list.stream()
            .filter(s -> s.length() > 5)
            .collect(java.util.stream.Collectors.toList());
        System.out.println("Filtered List: " + filteredList);

        // Example of using a parallel stream for concurrent processing
        list.parallelStream()
            .filter(s -> s.contains("a"))
            .forEach(s -> System.out.println("Parallel Stream Element: " + s));

        // Example of using a stream to group elements
        java.util.Map<Integer, java.util.List<String>> groupedByLength = list.stream()
            .collect(java.util.stream.Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);

        // Example of creating an infinite stream
        java.util.stream.Stream<Integer> infiniteStream = java.util.stream.Stream.iterate(0, n -> n + 1)
            .limit(10); // Limit to 10 elements
        infiniteStream.forEach(System.out::println);
    }
}
