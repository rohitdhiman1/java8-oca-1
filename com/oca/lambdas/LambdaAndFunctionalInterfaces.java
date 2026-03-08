package com.oca.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * This class demonstrates Lambda Expressions and Functional Interfaces, key features of Java 8.
 */

// A functional interface is an interface that contains exactly one abstract method.
// The @FunctionalInterface annotation is optional but recommended for clarity and compiler checks.
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaAndFunctionalInterfaces {

    public static void main(String[] args) {
        System.out.println("--- Custom Functional Interface ---");
        // A lambda expression is a short block of code which takes in parameters and returns a value.
        // It's an implementation of the abstract method in a functional interface.
        // Syntax: (parameters) -> { body }

        // Implementation for addition
        MathOperation addition = (a, b) -> a + b;
        System.out.println("10 + 5 = " + addition.operate(10, 5));

        // Implementation for subtraction (with explicit types and a block body)
        MathOperation subtraction = (int a, int b) -> {
            return a - b;
        };
        System.out.println("10 - 5 = " + subtraction.operate(10, 5));


        System.out.println("\n--- Built-in Functional Interfaces ---");
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));

        // 1. Predicate<T>: Represents a predicate (boolean-valued function) of one argument.
        // Method: boolean test(T t)
        // Example: Remove names that start with 'A'
        Predicate<String> startsWithA = (name) -> name.startsWith("A");
        names.removeIf(startsWithA);
        System.out.println("Names after removing those starting with 'A': " + names);


        // 2. Function<T, R>: Represents a function that accepts one argument and produces a result.
        // Method: R apply(T t)
        // Example: Get the length of each name.
        Function<String, Integer> getNameLength = (name) -> name.length();
        System.out.println("Length of 'Bob': " + getNameLength.apply("Bob"));


        // 3. Consumer<T>: Represents an operation that accepts a single input argument and returns no result.
        // Method: void accept(T t)
        // Example: Print each name.
        Consumer<String> printName = (name) -> System.out.println("Hello, " + name);
        System.out.println("Printing names using a Consumer:");
        names.forEach(printName);


        // 4. Supplier<T>: Represents a supplier of results. Takes no argument, returns a value.
        // Method: T get()
        System.out.println("\n--- Supplier<T> ---");
        Supplier<String> greeting = () -> "Hello from Supplier!";
        System.out.println(greeting.get());

        Supplier<List<String>> listFactory = () -> new ArrayList<>();
        List<String> newList = listFactory.get();
        newList.add("Created by Supplier");
        System.out.println("List from Supplier: " + newList);


        // 5. Method References (shorthand for lambdas that just call a single method)
        System.out.println("\n--- Method References ---");
        List<String> colors = Arrays.asList("red", "green", "blue");

        // Reference to an instance method of an arbitrary object: String::toUpperCase
        // Equivalent to: (s) -> s.toUpperCase()
        colors.stream().map(String::toUpperCase).forEach(System.out::println);

        // Reference to a static method: Integer::parseInt
        // Equivalent to: (s) -> Integer.parseInt(s)
        List<String> numberStrings = Arrays.asList("1", "2", "3");
        numberStrings.stream().map(Integer::parseInt).forEach(System.out::println);

        // Reference to an instance method of a specific object: System.out::println
        // Equivalent to: (s) -> System.out.println(s)
        System.out.println("Printing with method reference:");
        colors.forEach(System.out::println);
    }
}
