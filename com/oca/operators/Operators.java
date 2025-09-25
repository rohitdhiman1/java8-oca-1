package com.oca.operators;

/**
 * This class demonstrates the various operators in Java.
 */
public class Operators {

    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        // 1. Arithmetic Operators
        System.out.println("--- Arithmetic Operators ---");
        System.out.println("a + b = " + (a + b)); // Addition
        System.out.println("a - b = " + (a - b)); // Subtraction
        System.out.println("a * b = " + (a * b)); // Multiplication
        System.out.println("a / b = " + (a / b)); // Division
        System.out.println("a % b = " + (a % b)); // Modulus (remainder)

        // 2. Unary Operators
        System.out.println("\n--- Unary Operators ---");
        int c = 15;
        System.out.println("Post-increment c++: " + (c++)); // 15 (c becomes 16)
        System.out.println("Pre-increment ++c: " + (++c));  // 17 (c becomes 17)
        System.out.println("Post-decrement c--: " + (c--)); // 17 (c becomes 16)
        System.out.println("Pre-decrement --c: " + (--c));  // 15 (c becomes 15)
        System.out.println("Unary minus -c: " + (-c));      // -15
        boolean flag = true;
        System.out.println("Logical complement !flag: " + (!flag)); // false

        // 3. Assignment Operators
        System.out.println("\n--- Assignment Operators ---");
        int d = 5;
        d += 3; // d = d + 3
        System.out.println("d += 3: " + d); // 8
        d -= 2; // d = d - 2
        System.out.println("d -= 2: " + d); // 6
        d *= 4; // d = d * 4
        System.out.println("d *= 4: " + d); // 24
        d /= 3; // d = d / 3
        System.out.println("d /= 3: " + d); // 8

        // 4. Relational Operators
        System.out.println("\n--- Relational Operators ---");
        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a != b: " + (a != b)); // true
        System.out.println("a > b: " + (a > b));   // true
        System.out.println("a < b: " + (a < b));   // false
        System.out.println("a >= b: " + (a >= b)); // true
        System.out.println("a <= b: " + (a <= b)); // false

        // 5. Logical Operators
        System.out.println("\n--- Logical Operators ---");
        boolean x = true;
        boolean y = false;
        System.out.println("x && y: " + (x && y)); // Logical AND: false
        System.out.println("x || y: " + (x || y)); // Logical OR: true
        System.out.println("!x: " + (!x));         // Logical NOT: false

        // 6. Ternary Operator (shorthand for if-then-else)
        System.out.println("\n--- Ternary Operator ---");
        int min = (a < b) ? a : b;
        System.out.println("Minimum of a and b is: " + min); // 10

        // 7. Bitwise Operators
        System.out.println("\n--- Bitwise Operators ---");
        int num1 = 5;  // Binary: 0101
        int num2 = 3;  // Binary: 0011
        System.out.println("num1 & num2 (AND): " + (num1 & num2));   // 0001 -> 1
        System.out.println("num1 | num2 (OR): " + (num1 | num2));    // 0111 -> 7
        System.out.println("num1 ^ num2 (XOR): " + (num1 ^ num2));   // 0110 -> 6
        System.out.println("~num1 (Complement): " + (~num1));        // Inverts all bits
        System.out.println("num1 << 1 (Left Shift): " + (num1 << 1)); // 1010 -> 10
        System.out.println("num1 >> 1 (Right Shift): " + (num1 >> 1));// 0010 -> 2
    }
}
