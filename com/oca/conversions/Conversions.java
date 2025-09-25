package com.oca.conversions;

/**
 * This class demonstrates various type conversions (casting) in Java.
 */
public class Conversions {

    public static void main(String[] args) {
        // Widening Conversion (Implicit/Automatic)
        // Smaller data type is converted to a larger data type.
        int intVar = 100;
        long longVar = intVar; // int to long
        float floatVar = longVar; // long to float
        System.out.println("Widening Conversion:");
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("--------------------");

        // Narrowing Conversion (Explicit Casting)
        // Larger data type is converted to a smaller data type. Requires explicit cast.
        // Risk of data loss.
        double doubleVar = 12345.6789;
        long longFromDouble = (long) doubleVar; // double to long (fractional part lost)
        int intFromLong = (int) longFromDouble; // long to int
        byte byteFromInt = (byte) intFromLong; // int to byte (potential overflow)

        System.out.println("Narrowing Conversion:");
        System.out.println("double: " + doubleVar);
        System.out.println("long from double: " + longFromDouble);
        System.out.println("int from long: " + intFromLong);
        System.out.println("byte from int: " + byteFromInt);
        System.out.println("--------------------");

        // Conversion between numeric and char
        char charVar = 'A';
        int intFromChar = charVar; // char to int (gets ASCII/Unicode value)
        System.out.println("Conversion from char to int:");
        System.out.println("char: " + charVar);
        System.out.println("int from char: " + intFromChar);

        int anotherInt = 66;
        char charFromInt = (char) anotherInt; // int to char
        System.out.println("int: " + anotherInt);
        System.out.println("char from int: " + charFromInt);
        System.out.println("--------------------");

        // String to Numeric conversions
        String numStr = "123";
        int intFromString = Integer.parseInt(numStr);
        double doubleFromString = Double.parseDouble("45.67");
        System.out.println("String to Numeric:");
        System.out.println("int from String: " + (intFromString + 1)); // prove it's a number
        System.out.println("double from String: " + (doubleFromString + 1.0));
        System.out.println("--------------------");

        // Numeric to String conversions
        int num = 255;
        String strFromInt = String.valueOf(num);
        String strFromDouble = String.valueOf(123.45);
        System.out.println("Numeric to String:");
        System.out.println("String from int: " + strFromInt);
        System.out.println("String from double: " + strFromDouble);
    }
}
