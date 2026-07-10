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

        // 5. All Possible Conversions
        System.out.println("\n--- String -> Primitive ---");
        int    fromStr_int    = Integer.parseInt("42");
        long   fromStr_long   = Long.parseLong("999");
        double fromStr_double = Double.parseDouble("3.14");
        float  fromStr_float  = Float.parseFloat("1.5f");
        boolean fromStr_bool  = Boolean.parseBoolean("true");
        short  fromStr_short  = Short.parseShort("100");
        byte   fromStr_byte   = Byte.parseByte("10");
        System.out.println("String->int:     " + fromStr_int);
        System.out.println("String->long:    " + fromStr_long);
        System.out.println("String->double:  " + fromStr_double);
        System.out.println("String->float:   " + fromStr_float);
        System.out.println("String->boolean: " + fromStr_bool);
        System.out.println("String->short:   " + fromStr_short);
        System.out.println("String->byte:    " + fromStr_byte);

        System.out.println("\n--- String -> Wrapper (valueOf) ---");
        Integer   fromStr_Integer = Integer.valueOf("42");     // String -> Integer
        Double    fromStr_Double  = Double.valueOf("3.14");    // String -> Double
        Boolean   fromStr_Boolean = Boolean.valueOf("true");   // String -> Boolean
        System.out.println("String->Integer: " + fromStr_Integer);
        System.out.println("String->Double:  " + fromStr_Double);
        System.out.println("String->Boolean: " + fromStr_Boolean);

        System.out.println("\n--- Primitive -> String ---");
        String str1 = String.valueOf(42);           // int -> String
        String str2 = String.valueOf(3.14);         // double -> String
        String str3 = String.valueOf(true);         // boolean -> String
        String str4 = Integer.toString(42);         // int -> String (via wrapper)
        String str5 = 42 + "";                      // int -> String (concatenation trick)
        System.out.println("int->String (valueOf):    " + str1);
        System.out.println("double->String (valueOf): " + str2);
        System.out.println("bool->String (valueOf):   " + str3);
        System.out.println("int->String (toString):   " + str4);
        System.out.println("int->String (+ \"\"):       " + str5);

        System.out.println("\n--- Wrapper -> String ---");
        Integer wrapInt = 42;
        int abc = 76;
        String fromWrapper1 = wrapInt.toString();       // instance method
        String fromWrapper2 = Integer.toString(42);     // static method
        String fromWrapper3 = String.valueOf(abc);  // String.valueOf
        System.out.println("Integer->String (instance toString): " + fromWrapper1);
        System.out.println("Integer->String (static toString):   " + fromWrapper2);
        System.out.println("Integer->String (String.valueOf):    " + fromWrapper3);

        System.out.println("\n--- Primitive -> Wrapper ---");
        Integer boxed1 = Integer.valueOf(42);   // explicit boxing
        Integer boxed2 = 42;                    // autoboxing
        Double  boxed3 = Double.valueOf(3.14);  // explicit boxing
        System.out.println("int->Integer (valueOf):   " + boxed1);
        System.out.println("int->Integer (autobox):   " + boxed2);
        System.out.println("double->Double (valueOf): " + boxed3);

        System.out.println("\n--- Wrapper -> Primitive ---");
        Integer wrappedVal = 42;
        int   unboxed1 = wrappedVal;              // autounboxing
        int   unboxed2 = wrappedVal.intValue();   // explicit unboxing
        long  unboxed3 = wrappedVal.longValue();  // widening via wrapper method
        double unboxed4 = wrappedVal.doubleValue();
        System.out.println("Integer->int (autounbox):     " + unboxed1);
        System.out.println("Integer->int (intValue):      " + unboxed2);
        System.out.println("Integer->long (longValue):    " + unboxed3);
        System.out.println("Integer->double (doubleValue):" + unboxed4);

        System.out.println("\n--- Primitive Widening (automatic) ---");
        byte  b = 10;
        short s = b;        // byte -> short
        int   i = s;        // short -> int
        long  l = i;        // int -> long
        float f = l;        // long -> float
        double dbl = f;     // float -> double
        System.out.println("byte->short->int->long->float->double: " + dbl);

        System.out.println("\n--- Primitive Narrowing (requires explicit cast) ---");
        double bigVal = 9.99;
        int    narrowed1 = (int) bigVal;    // truncates decimal
        byte   narrowed2 = (byte) 200;      // overflow: 200 > 127, wraps around
        System.out.println("(int) 9.99 = " + narrowed1);
        System.out.println("(byte) 200 = " + narrowed2);

        // 6. valueOf() vs parseInt() - summary
        System.out.println("\n--- valueOf() vs parseInt() ---");
        int primitiveResult = Integer.parseInt("42");   // Returns primitive int
        Integer objectResult = Integer.valueOf("42");   // Returns Integer object
        System.out.println("parseInt returns int: " + primitiveResult);
        System.out.println("valueOf returns Integer: " + objectResult);

        // 7. EXAM TRAP: Integer cache (-128 to 127)
        System.out.println("\n--- Integer Cache (EXAM TRAP) ---");
        // Java caches Integer objects for values -128 to 127
        Integer a = 127;
        Integer a1 = 127;
        System.out.println("a = 127, b = 127");
        System.out.println("a == b: " + (a == a1));       // true (cached, same object)
        System.out.println("a.equals(b): " + a.equals(a1)); // true

        Integer c = 128;
        Integer d = 128;
        System.out.println("\nc = 128, d = 128");
        System.out.println("c == d: " + (c == d));       // false (not cached, different objects!)
        System.out.println("c.equals(d): " + c.equals(d)); // true

        // Lesson: Always use .equals() to compare wrapper objects!

        // 8. Comparing with == vs .equals()
        System.out.println("\n--- == vs .equals() ---");
        Integer x = new Integer(10);
        Integer y = new Integer(10);
        System.out.println("new Integer(10) == new Integer(10): " + (x == y)); // false (different objects)
        System.out.println("new Integer(10).equals(new Integer(10)): " + x.equals(y)); // true

        // 9. Useful wrapper methods
        System.out.println("\n--- Useful Wrapper Methods ---");
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer.toBinaryString(10): " + Integer.toBinaryString(10));
        System.out.println("Character.isDigit('9'): " + Character.isDigit('9'));
        System.out.println("Character.isLetter('A'): " + Character.isLetter('A'));
        System.out.println("Character.toUpperCase('a'): " + Character.toUpperCase('a'));
    }
}
