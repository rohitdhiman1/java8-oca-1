package com.oca.finalkeyword;

/**
 * This class demonstrates the use of the 'final' keyword.
 * 'final' can be applied to variables, methods, and classes.
 */

// 1. final class: A final class cannot be extended (inherited).
final class FinalClass {
    public void show() {
        System.out.println("This is a final class.");
    }
}
// class SubClass extends FinalClass {} // This would cause a compile error.


class BaseClass {
    // 2. final method: A final method cannot be overridden by a subclass.
    public final void finalMethod() {
        System.out.println("This is a final method in BaseClass.");
    }

    public void regularMethod() {
        System.out.println("This is a regular method in BaseClass.");
    }
}

class DerivedClass extends BaseClass {
    // @Override
    // public void finalMethod() {} // This would cause a compile error.

    @Override
    public void regularMethod() {
        System.out.println("This is the overridden regular method in DerivedClass.");
    }
}


public class FinalKeywordExample {

    // 3. final variable: A final variable's value cannot be changed once it has been initialized.
    // It's a constant.

    // A final instance variable - must be initialized at declaration or in the constructor.
    private final int instanceFinalVar;

    // A static final variable (a compile-time constant) - must be initialized at declaration or in a static block.
    private static final String CLASS_CONSTANT = "Hello from Final!";

    public FinalKeywordExample(int value) {
        // Initialize the final instance variable in the constructor.
        this.instanceFinalVar = value;
    }

    public void displayValue() {
        System.out.println("Instance final variable: " + instanceFinalVar);
    }

    public void tryChangeValue() {
        // this.instanceFinalVar = 100; // This would cause a compile error.
    }

    public static void main(String[] args) {
        // Using the final variable
        FinalKeywordExample obj = new FinalKeywordExample(42);
        obj.displayValue();
        System.out.println("Static final constant: " + FinalKeywordExample.CLASS_CONSTANT);

        // A final local variable
        final String localFinalVar = "I am local and final.";
        // localFinalVar = "Trying to change"; // This would cause a compile error.
        System.out.println(localFinalVar);

        // Using final method and class
        DerivedClass derivedObj = new DerivedClass();
        derivedObj.finalMethod(); // Can be called
        derivedObj.regularMethod(); // Can be called
    }
}
