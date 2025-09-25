package com.oca.controlflow;

/**
 * This class demonstrates the control flow statements in Java.
 */
public class ControlFlow {

    public static void main(String[] args) {
        System.out.println("--- If-Else-If-Else Statement ---");
        int score = 75;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: D or F");
        }

        System.out.println("\n--- Switch Statement ---");
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
                break;
        }

        System.out.println("\n--- For Loop ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }

        System.out.println("\n--- Enhanced For Loop (For-Each) ---");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }

        System.out.println("\n--- While Loop ---");
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }

        System.out.println("\n--- Do-While Loop ---");
        // This loop will execute at least once.
        int j = 5;
        do {
            System.out.println("j: " + j);
            j++;
        } while (j < 5);

        System.out.println("\n--- Break and Continue ---");
        for (int k = 0; k < 10; k++) {
            if (k == 7) {
                System.out.println("Breaking loop at k = 7");
                break; // Exit the loop
            }
            if (k % 2 != 0) {
                continue; // Skip the current iteration for odd numbers
            }
            System.out.println("Processing even number: " + k);
        }
    }
}
