package com.oca.passbyvalue;

/**
 * This class demonstrates that Java is always pass-by-value.
 * For primitives, the value is copied. For objects, the reference is copied.
 */
public class PassByValue {

    public static void main(String[] args) {
        // 1. Passing primitives - value is copied, original is unchanged
        System.out.println("--- Passing Primitives ---");
        int num = 10;
        System.out.println("Before modifyPrimitive(): num = " + num);
        modifyPrimitive(num);
        System.out.println("After modifyPrimitive(): num = " + num); // Still 10

        // 2. Passing object references - reference is copied, both point to same object
        System.out.println("\n--- Passing Object References ---");
        int[] arr = {1, 2, 3};
        System.out.println("Before modifyArray(): arr[0] = " + arr[0]);
        modifyArray(arr);
        System.out.println("After modifyArray(): arr[0] = " + arr[0]); // Changed to 99

        // 3. Reassigning reference inside method doesn't affect caller
        System.out.println("\n--- Reassigning Reference Inside Method ---");
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Before reassignReference(): sb = " + sb);
        reassignReference(sb);
        System.out.println("After reassignReference(): sb = " + sb); // Still "Hello"

        // 4. Modifying vs reassigning - key distinction
        System.out.println("\n--- Modify vs Reassign ---");
        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println("Before appendToBuilder(): sb2 = " + sb2);
        appendToBuilder(sb2);
        System.out.println("After appendToBuilder(): sb2 = " + sb2); // "Hello World"

        // 5. Swap example - does NOT work (common exam question)
        System.out.println("\n--- Swap Example (Does Not Work) ---");
        String a = "First";
        String b = "Second";
        System.out.println("Before swap(): a = " + a + ", b = " + b);
        swap(a, b);
        System.out.println("After swap(): a = " + a + ", b = " + b); // Unchanged!
    }

    // The parameter 'x' is a copy of the original value
    public static void modifyPrimitive(int x) {
        x = 999;
        System.out.println("  Inside modifyPrimitive(): x = " + x);
    }

    // The parameter 'array' is a copy of the reference, but points to the same array
    public static void modifyArray(int[] array) {
        array[0] = 99; // This modifies the original array
        System.out.println("  Inside modifyArray(): array[0] = " + array[0]);
    }

    // Reassigning the reference inside the method does not affect the caller
    public static void reassignReference(StringBuilder builder) {
        builder = new StringBuilder("World"); // This only changes the local copy of the reference
        System.out.println("  Inside reassignReference(): builder = " + builder);
    }

    // Modifying the object through the copied reference DOES affect the original
    public static void appendToBuilder(StringBuilder builder) {
        builder.append(" World"); // This modifies the actual object
        System.out.println("  Inside appendToBuilder(): builder = " + builder);
    }

    // Swap does NOT work because Java is pass-by-value
    public static void swap(String x, String y) {
        String temp = x;
        x = y;
        y = temp;
        System.out.println("  Inside swap(): x = " + x + ", y = " + y); // Swapped locally only
    }
}
