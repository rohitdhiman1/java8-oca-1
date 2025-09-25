package com.oca.arrays;

import java.util.Arrays;

/**
 * This class demonstrates the declaration, instantiation, initialization, and use of arrays in Java.
 */
public class ArraysExample {

    public static void main(String[] args) {
        // 1. Declaration and Instantiation
        // Declares an array of integers and allocates memory for 5 integers.
        int[] numbers = new int[5];

        // 2. Initialization
        // Assigning values to array elements by index.
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        // numbers[5] = 60; // This would cause an ArrayIndexOutOfBoundsException

        System.out.println("--- Accessing Array Elements ---");
        System.out.println("Element at index 2: " + numbers[2]);

        // 3. Declaration, Instantiation, and Initialization in one line
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println("Element at index 0: " + fruits[0]);

        // 4. Iterating over an array
        System.out.println("\n--- Iterating with a for loop ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element " + i + ": " + numbers[i]);
        }

        System.out.println("\n--- Iterating with an enhanced for loop (for-each) ---");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // 5. Multi-dimensional Arrays
        // A 2D array is an array of arrays.
        System.out.println("\n--- Multi-dimensional Array ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Element at row 1, column 2: " + matrix[1][2]); // Should be 6

        // Iterating over a 2D array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 6. The java.util.Arrays utility class
        System.out.println("\n--- java.util.Arrays Utility ---");
        int[] unsortedNumbers = {5, 2, 8, 1, 9};
        System.out.println("Unsorted array: " + Arrays.toString(unsortedNumbers));

        // Sorting an array
        Arrays.sort(unsortedNumbers);
        System.out.println("Sorted array: " + Arrays.toString(unsortedNumbers));

        // Searching in a sorted array
        int index = Arrays.binarySearch(unsortedNumbers, 8);
        System.out.println("The number 8 is at index: " + index);
    }
}
