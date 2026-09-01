package com.oca.lambdas;

import java.util.HashMap;

/**
 * Demonstrates the differences between a Lambda expression and an Anonymous Class
 * that implement the same functional interface.
 */
public class LambdaVsAnonymousClass {

    interface Greeter {
        void greet();
    }

    // Anonymous classes can extend a concrete class -- a lambda never can, since a
    // lambda only ever supplies the body of a functional interface's single abstract method.
    static class Animal {
        void sound() {
            System.out.println("Some generic animal sound");
        }
    }

    int enclosingField = 100;

    void demonstrateThis() {
        System.out.println("Enclosing object (this) identity: " + System.identityHashCode(this));

        // Lambda: does NOT create its own `this`. Inside the body, `this` is inherited
        // from the enclosing instance.
        Greeter lambdaGreeter = () -> System.out.println(
                "`this` inside lambda body:     " + System.identityHashCode(this) + "  (matches enclosing)");

        // Anonymous class: DOES create its own `this` -- a brand-new object.
        Greeter anonymousGreeter = new Greeter() {
            @Override
            public void greet() {
                System.out.println(
                        "`this` inside anonymous body:  " + System.identityHashCode(this) + "  (its own object)");
            }
        };

        lambdaGreeter.greet();
        anonymousGreeter.greet();

        // Both are still real objects at runtime -- each with its own class and identity --
        // even though the lambda's `this` keyword doesn't point at the lambda object itself.
        System.out.println("\nLambda object     -> class: " + lambdaGreeter.getClass().getName()
                + ", identity: " + System.identityHashCode(lambdaGreeter));
        System.out.println("Anonymous object  -> class: " + anonymousGreeter.getClass().getName()
                + ", identity: " + System.identityHashCode(anonymousGreeter));
    }

    void demonstrateCapture() {
        int local = 5; // must be effectively final to be captured by either

        Greeter lambdaCapture = () -> System.out.println("Lambda captured local: " + local);
        Greeter anonymousCapture = new Greeter() {
            @Override
            public void greet() {
                System.out.println("Anonymous captured local: " + local);
            }
        };

        lambdaCapture.greet();
        anonymousCapture.greet();
        // local = 6; // if uncommented, both captures above would fail to compile
    }

    void demonstrateExtraMembers() {
        // Anonymous classes can add fields and extra methods beyond the interface's abstract method.
        Greeter anonymousWithState = new Greeter() {
            int callCount = 0; // extra field -- not possible in a lambda

            @Override
            public void greet() {
                callCount++;
                System.out.println("Anonymous called " + callCount + " time(s)");
            }
        };
        anonymousWithState.greet();
        anonymousWithState.greet();

        // A lambda has no body other than the SAM implementation, so it cannot hold a field
        // that survives between calls.
    }

    void demonstrateExtendClass() {
        // Only a class -- named or anonymous -- can extend another class.
        // A lambda can only ever implement a functional interface, never extend a class.
        Animal anonymousAnimal = new Animal() {
            @Override
            void sound() {
                System.out.println("Anonymous subclass overrides sound()");
            }
        };
        anonymousAnimal.sound();
    }

    public static void main(String[] args) {
        LambdaVsAnonymousClass demo = new LambdaVsAnonymousClass();

        System.out.println("--- this context ---");
        demo.demonstrateThis();

        System.out.println("\n--- capturing local variables ---");
        demo.demonstrateCapture();

        System.out.println("\n--- extra fields/methods ---");
        demo.demonstrateExtraMembers();

        System.out.println("\n--- extending a class ---");
        demo.demonstrateExtendClass();
    }
}
