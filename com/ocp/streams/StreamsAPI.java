package com.ocp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates the Java 8 Streams API for processing collections of objects.
 * A stream is a sequence of elements supporting sequential and parallel aggregate operations.
 */
public class StreamsAPI {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Alex", "David");

        System.out.println("Original list of names: " + names);

        // A stream pipeline consists of:
        // 1. A source (e.g., a collection).
        // 2. Zero or more intermediate operations (e.g., filter, map). These are lazy.
        // 3. A terminal operation (e.g., forEach, collect). This triggers the processing.

        // Example: Find all names starting with 'A', convert them to uppercase, and print them.
        System.out.println("\n--- Example 1: filter, map, forEach ---");
        names.stream()                                  // 1. Source
            .filter(name -> name.startsWith("A"))       // 2. Intermediate Op: filter
            .map(name -> name.toUpperCase())            // 2. Intermediate Op: map
            .forEach(name -> System.out.println(name)); // 3. Terminal Op: forEach


        // Example: Create a new list containing names that have 4 letters.
        System.out.println("\n--- Example 2: filter, collect ---");
        List<String> fourLetterNames = names.stream()
            .filter(name -> name.length() == 4)
            .collect(Collectors.toList()); // Terminal Op: collect to a new List
        System.out.println("Names with 4 letters: " + fourLetterNames);


        // Example: Find the sum of the squares of a list of numbers.
        System.out.println("\n--- Example 3: map, reduce ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfSquares = numbers.stream()
            .map(n -> n * n) // Square each number
            .reduce(0, (a, b) -> a + b); // Terminal Op: reduce to a single value
            // The first argument (0) is the identity (initial value).
            // The second argument is the accumulator function.
        System.out.println("Sum of squares for " + numbers + " is: " + sumOfSquares);


        // Example: Find the first name that starts with 'C'.
        System.out.println("\n--- Example 4: findFirst ---");
        String firstNameWithC = names.stream()
            .filter(name -> name.startsWith("C"))
            .findFirst()
            .orElse("No name found"); // Handle the case where no such name exists
        System.out.println("First name starting with 'C': " + firstNameWithC);
    }
}
