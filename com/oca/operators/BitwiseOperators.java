package com.oca.operators;

public class BitwiseOperators {

    public static void main(String[] args) {
        int a = 5;  // 0101 in binary
        int b = 3;  // 0011 in binary

        // Bitwise AND (&)
        // 0101 & 0011 = 0001 (1)
        System.out.println("a & b = " + (a & b));

        // Bitwise OR (|)
        // 0101 | 0011 = 0111 (7)
        System.out.println("a | b = " + (a | b));

        // Bitwise XOR (^)
        // 0101 ^ 0011 = 0110 (6)
        System.out.println("a ^ b = " + (a ^ b));

        // Bitwise Complement (~)
        // ~0101 = 1010 (-6)
        System.out.println("~a = " + (~a));

        // Signed Left Shift (<<)
        // 0101 << 2 = 010100 (20)
        System.out.println("a << 2 = " + (a << 2));

        // Signed Right Shift (>>)
        // 0101 >> 2 = 0001 (1)
        System.out.println("a >> 2 = " + (a >> 2));

        // Unsigned Right Shift (>>>)
        int c = -5; // 11111111111111111111111111111011 in binary
        // c >>> 2 = 00111111111111111111111111111110 (1073741822)
        System.out.println("c >>> 2 = " + (c >>> 2));
    }
}
