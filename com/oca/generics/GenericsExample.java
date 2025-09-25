package com.oca.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates the use of Generics in Java.
 * Generics provide type-safety to collections and classes, allowing you to detect errors at compile-time.
 */

// 1. Generic Class
// Here, 'T' is a type parameter that will be replaced by a real type when an object is created.
class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class GenericsExample {

    // 2. Generic Method
    // This method has its own type parameter 'E'.
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    // 3. Bounded Type Parameters (Upper Bounded Wildcard)
    // The '?' is a wildcard. 'extends Number' means it can be any type that is a subclass of Number.
    // This method can accept a List of Integer, Double, Float, etc.
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("--- Generic Class ---");
        // Create a Box for Integers
        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(123);
        // integerBox.setContent("hello"); // This would cause a compile error due to type-safety.
        System.out.println("Integer Box content: " + integerBox.getContent());

        // Create a Box for Strings
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello Generics");
        System.out.println("String Box content: " + stringBox.getContent());

        System.out.println("\n--- Generic Method ---");
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"A", "B", "C"};
        System.out.print("Integer Array: ");
        printArray(intArray);
        System.out.print("String Array: ");
        printArray(stringArray);

        System.out.println("\n--- Bounded Type Parameters ---");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        System.out.println("Sum of integer list: " + sumOfList(integerList));

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        System.out.println("Sum of double list: " + sumOfList(doubleList));

        // List<String> stringList = new ArrayList<>();
        // stringList.add("test");
        // System.out.println(sumOfList(stringList)); // This would cause a compile error.
    }
}
