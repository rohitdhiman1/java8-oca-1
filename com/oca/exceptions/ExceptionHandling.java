package com.oca.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class demonstrates exception handling in Java using try-catch, finally, and throws.
 */
public class ExceptionHandling {

    public static void main(String[] args) {
        // 1. Handling a checked exception: FileNotFoundException
        handleCheckedException();

        System.out.println("\n--------------------\n");

        // 2. Handling a common unchecked exception: ArithmeticException
        handleUncheckedException();

        System.out.println("\n--------------------\n");

        // 3. Using the 'finally' block
        demonstrateFinally();

        System.out.println("\n--------------------\n");

        // 4. Multi-catch block (Java 7+)
        demonstrateMultiCatch();

        System.out.println("\n--------------------\n");

        // 5. Using the 'throws' keyword
        try {
            findFile();
        } catch (IOException e) {
            System.out.println("Caught exception from findFile() in main: " + e.getMessage());
        }
    }

    public static void handleCheckedException() {
        System.out.println("Trying to read a file that doesn't exist...");
        try (FileReader fr = new FileReader("non_existent_file.txt")) {
            // Code that might throw a checked exception must be handled.
            System.out.println("File found and opened.");
        } catch (FileNotFoundException e) {
            // This block is executed if a FileNotFoundException occurs.
            System.out.println("Caught a checked exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
            // e.printStackTrace(); // Useful for debugging
        } catch (IOException e) {
            System.out.println("Caught an IO exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println("Execution continues after handling the checked exception.");
    }

    public static void handleUncheckedException() {
        System.out.println("Trying to divide by zero...");
        int a = 10;
        int b = 0;
        try {
            // Unchecked exceptions (like ArithmeticException) don't have to be handled,
            // but it's good practice if you can anticipate them.
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // This block is executed if an ArithmeticException occurs.
            System.out.println("Caught an unchecked exception: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println("Execution continues after handling the unchecked exception.");
    }

    public static void demonstrateFinally() {
        System.out.println("Demonstrating the 'finally' block...");
        try {
            System.out.println("Inside the try block.");
            int result = 5 / 0; // This will throw an exception
            System.out.println("This line will not be executed." + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception in demonstrateFinally: " + e.getMessage());
        } finally {
            // The 'finally' block is always executed, whether an exception occurred or not.
            // It's often used for cleanup, like closing files or database connections.
            System.out.println("This is the 'finally' block. It always runs!");
        }
    }

    public static void demonstrateMultiCatch() {
        System.out.println("Demonstrating multi-catch block (Java 7+)...");
        String[] data = {"10", null, "abc"};

        for (String item : data) {
            try {
                // Could throw NullPointerException (null.length()) or
                // NumberFormatException (Integer.parseInt("abc"))
                int result = 100 / Integer.parseInt(item);
                System.out.println("  100 / " + item + " = " + result);
            } catch (ArithmeticException | NumberFormatException | NullPointerException e) {
                // Multi-catch: the variable 'e' is implicitly final
                // Exception types must not be related (no parent-child)
                System.out.println("  Caught " + e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }

    // This method declares that it might throw a FileNotFoundException.
    // It delegates the responsibility of handling the exception to the calling method.
    public static void findFile() throws IOException {
        System.out.println("Inside findFile(), which 'throws' an exception.");
        // No try-catch block here. The exception is passed up the call stack.
        try (FileReader fr = new FileReader("another_non_existent_file.txt")) {
            System.out.println("File found and opened." + fr);
        }
    }
}
