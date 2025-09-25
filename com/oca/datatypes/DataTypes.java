package com.oca.datatypes;

/**
 * This class demonstrates the 8 primitive data types in Java.
 */
public class DataTypes {

    public static void main(String[] args) {
        // Primitive Data Types

        // byte: 8-bit signed two's complement integer.
        // Range: -128 to 127
        byte byteVar = 100;
        System.out.println("byte: " + byteVar);
        System.out.println("Byte min: " + Byte.MIN_VALUE + ", Byte max: " + Byte.MAX_VALUE);


        // short: 16-bit signed two's complement integer.
        // Range: -32,768 to 32,767
        short shortVar = 30000;
        System.out.println("short: " + shortVar);
        System.out.println("Short min: " + Short.MIN_VALUE + ", Short max: " + Short.MAX_VALUE);

        // int: 32-bit signed two's complement integer.
        // Range: -2^31 to 2^31-1
        int intVar = 2000000000;
        System.out.println("int: " + intVar);
        System.out.println("Integer min: " + Integer.MIN_VALUE + ", Integer max: " + Integer.MAX_VALUE);

        // long: 64-bit signed two's complement integer.
        // Range: -2^63 to 2^63-1
        long longVar = 9000000000000000000L; // 'L' or 'l' suffix denotes a long literal
        System.out.println("long: " + longVar);
        System.out.println("Long min: " + Long.MIN_VALUE + ", Long max: " + Long.MAX_VALUE);

        // float: 32-bit single-precision floating-point.
        float floatVar = 3.14f; // 'f' or 'F' suffix denotes a float literal
        System.out.println("float: " + floatVar);
        System.out.println("Float min: " + Float.MIN_VALUE + ", Float max: " + Float.MAX_VALUE);

        // double: 64-bit double-precision floating-point.
        double doubleVar = 3.14159265359;
        System.out.println("double: " + doubleVar);
        System.out.println("Double min: " + Double.MIN_VALUE + ", Double max: " + Double.MAX_VALUE);

        // char: 16-bit Unicode character.
        // Range: 0 to 65,535
        char charVar = 'A';
        System.out.println("char: " + charVar);

        // boolean: Represents two values: true and false.
        boolean booleanVar = true;
        System.out.println("boolean: " + booleanVar);

        // Reference Data Types (using String as an example)
        // They hold references to objects.
        String stringVar = "Hello, Java!";
        System.out.println("String (Reference Type): " + stringVar);
    }
}
