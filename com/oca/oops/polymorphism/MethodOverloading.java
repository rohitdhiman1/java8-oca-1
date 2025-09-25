package com.oca.oops.polymorphism;

/**
 * This class demonstrates Method Overloading (Compile-time Polymorphism).
 * Method overloading allows defining multiple methods in the same class with the same name,
 * as long as their parameter lists are different (either by number of parameters or type of parameters).
 */
public class MethodOverloading {

    // Method to add two integers
    public int add(int a, int b) {
        System.out.println("Called add(int, int)");
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        System.out.println("Called add(int, int, int)");
        return a + b + c;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        System.out.println("Called add(double, double)");
        return a + b;
    }

    // Overloaded method with different parameter order
    public String combine(String s, int i) {
        System.out.println("Called combine(String, int)");
        return s + i;
    }

    public String combine(int i, String s) {
        System.out.println("Called combine(int, String)");
        return i + s;
    }

    public static void main(String[] args) {
        MethodOverloading calculator = new MethodOverloading();

        // The compiler decides which method to call based on the arguments provided.
        System.out.println("Sum of 2 and 3 is: " + calculator.add(2, 3));
        System.out.println("Sum of 2, 3, and 4 is: " + calculator.add(2, 3, 4));
        System.out.println("Sum of 2.5 and 3.5 is: " + calculator.add(2.5, 3.5));

        System.out.println("Combined string and int: " + calculator.combine("Number", 10));
        System.out.println("Combined int and string: " + calculator.combine(20, "Value"));
    }
}
