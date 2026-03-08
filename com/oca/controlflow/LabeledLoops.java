package com.oca.controlflow;

/**
 * This class demonstrates labeled loops with break and continue.
 * Labels allow you to control which loop to break out of or continue in nested loops.
 */
public class LabeledLoops {

    public static void main(String[] args) {
        // 1. Labeled break - exits the labeled (outer) loop entirely
        System.out.println("--- Labeled break ---");
        OUTER:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("Breaking OUTER at i=" + i + ", j=" + j);
                    break OUTER; // Exits both loops
                }
                System.out.println("  i=" + i + ", j=" + j);
            }
        }
        System.out.println("After OUTER loop");

        // 2. Labeled continue - skips to next iteration of the labeled (outer) loop
        System.out.println("\n--- Labeled continue ---");
        OUTER_LOOP:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    System.out.println("  Continuing OUTER_LOOP at i=" + i + ", j=" + j);
                    continue OUTER_LOOP; // Skips rest of inner loop, goes to next i
                }
                System.out.println("  i=" + i + ", j=" + j);
            }
        }

        // 3. Labeled while loop
        System.out.println("\n--- Labeled while loop ---");
        int x = 0;
        WHILE_OUTER:
        while (x < 3) {
            int y = 0;
            while (y < 3) {
                if (x == 1 && y == 2) {
                    System.out.println("Breaking WHILE_OUTER at x=" + x + ", y=" + y);
                    break WHILE_OUTER;
                }
                System.out.println("  x=" + x + ", y=" + y);
                y++;
            }
            x++;
        }

        // 4. Matrix search - common exam pattern
        System.out.println("\n--- Matrix Search (Find a value) ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int target = 5;
        boolean found = false;

        SEARCH:
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    System.out.println("Found " + target + " at [" + row + "][" + col + "]");
                    found = true;
                    break SEARCH; // Exit both loops immediately
                }
            }
        }
        if (!found) {
            System.out.println(target + " not found in matrix");
        }

        // 5. Contrast: break vs break LABEL vs continue vs continue LABEL
        System.out.println("\n--- Contrast: break vs break LABEL ---");
        System.out.println("Regular break (only exits inner loop):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) break; // Only exits inner loop
                System.out.println("  i=" + i + ", j=" + j);
            }
        }
        System.out.println("\nLabeled break (exits outer loop):");
        EXIT:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) break EXIT; // Exits outer loop
                System.out.println("  i=" + i + ", j=" + j);
            }
        }
    }
}
