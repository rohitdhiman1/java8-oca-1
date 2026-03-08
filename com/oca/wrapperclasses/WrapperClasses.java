package com.oca.wrapperclasses;

/**
 * This class demonstrates wrapper classes, autoboxing, unboxing,
 * and common exam traps related to wrapper object comparison.
 */
public class WrapperClasses {

    public static void main(String[] args) {
        // 1. The 8 wrapper classes (one for each primitive)
        System.out.println("--- Wrapper Classes ---");
        Boolean boolWrapper = true;         // boolean -> Boolean
        Byte byteWrapper = 10;              // byte -> Byte
        Short shortWrapper = 100;           // short -> Short
        Integer intWrapper = 1000;          // int -> Integer
        Long longWrapper = 10000L;          // long -> Long
        Float floatWrapper = 3.14f;         // float -> Float
        Double doubleWrapper = 3.14159;     // double -> Double
        Character charWrapper = 'A';        // char -> Character

        System.out.println("Boolean: " + boolWrapper);
        System.out.println("Byte: " + byteWrapper);
        System.out.println("Short: " + shortWrapper);
        System.out.println("Integer: " + intWrapper);
        System.out.println("Long: " + longWrapper);
        System.out.println("Float: " + floatWrapper);
        System.out.println("Double: " + doubleWrapper);
        System.out.println("Character: " + charWrapper);

        // 2. Autoboxing: primitive -> wrapper (automatic)
        System.out.println("\n--- Autoboxing ---");
        Integer autoBoxed = 42; // int 42 is automatically boxed into Integer
        System.out.println("Autoboxed int 42 to Integer: " + autoBoxed);

        // 3. Unboxing: wrapper -> primitive (automatic)
        System.out.println("\n--- Unboxing ---");
        int unboxed = autoBoxed; // Integer is automatically unboxed to int
        System.out.println("Unboxed Integer to int: " + unboxed);

        // Watch out: unboxing null throws NullPointerException
        // Integer nullInt = null;
        // int willCrash = nullInt; // NullPointerException at runtime!

        // 4. Parsing Strings to primitives
        System.out.println("\n--- Parsing Strings ---");
        int parsedInt = Integer.parseInt("123");         // returns int
        double parsedDouble = Double.parseDouble("3.14"); // returns double
        boolean parsedBool = Boolean.parseBoolean("true"); // returns boolean
        long parsedLong = Long.parseLong("999999");       // returns long
        System.out.println("parseInt(\"123\"): " + parsedInt);
        System.out.println("parseDouble(\"3.14\"): " + parsedDouble);
        System.out.println("parseBoolean(\"true\"): " + parsedBool);
        System.out.println("parseLong(\"999999\"): " + parsedLong);

        // 5. valueOf() vs parseInt() - key difference
        System.out.println("\n--- valueOf() vs parseInt() ---");
        int primitiveResult = Integer.parseInt("42");   // Returns primitive int
        Integer objectResult = Integer.valueOf("42");   // Returns Integer object
        System.out.println("parseInt returns int: " + primitiveResult);
        System.out.println("valueOf returns Integer: " + objectResult);

        // 6. EXAM TRAP: Integer cache (-128 to 127)
        System.out.println("\n--- Integer Cache (EXAM TRAP) ---");
        // Java caches Integer objects for values -128 to 127
        Integer a = 127;
        Integer b = 127;
        System.out.println("a = 127, b = 127");
        System.out.println("a == b: " + (a == b));       // true (cached, same object)
        System.out.println("a.equals(b): " + a.equals(b)); // true

        Integer c = 128;
        Integer d = 128;
        System.out.println("\nc = 128, d = 128");
        System.out.println("c == d: " + (c == d));       // false (not cached, different objects!)
        System.out.println("c.equals(d): " + c.equals(d)); // true

        // Lesson: Always use .equals() to compare wrapper objects!

        // 7. Comparing with == vs .equals()
        System.out.println("\n--- == vs .equals() ---");
        Integer x = new Integer(10);
        Integer y = new Integer(10);
        System.out.println("new Integer(10) == new Integer(10): " + (x == y)); // false (different objects)
        System.out.println("new Integer(10).equals(new Integer(10)): " + x.equals(y)); // true

        // 8. Useful wrapper methods
        System.out.println("\n--- Useful Wrapper Methods ---");
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer.toBinaryString(10): " + Integer.toBinaryString(10));
        System.out.println("Character.isDigit('9'): " + Character.isDigit('9'));
        System.out.println("Character.isLetter('A'): " + Character.isLetter('A'));
        System.out.println("Character.toUpperCase('a'): " + Character.toUpperCase('a'));
    }
}
