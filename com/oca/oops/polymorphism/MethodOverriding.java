package com.oca.oops.polymorphism;

/**
 * This example demonstrates Method Overriding (Runtime Polymorphism).
 * A reference variable of a superclass type can refer to an object of its subclass.
 * When a method is called through the superclass reference, the Java Virtual Machine (JVM)
 * determines which version of the method to execute (superclass's or subclass's) based on
 * the actual object type at runtime. This is also known as dynamic method dispatch.
 */

// Superclass
class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

// Subclass
class Car extends Vehicle {
    // Overriding the run method of Vehicle
    @Override
    void run() {
        System.out.println("Car is running safely");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        // A Vehicle reference referring to a Vehicle object
        Vehicle v1 = new Vehicle();
        v1.run(); // Calls the run method in Vehicle class

        // A Car reference referring to a Car object
        Car c1 = new Car();
        c1.run(); // Calls the overridden run method in Car class

        System.out.println("--- Runtime Polymorphism ---");
        // A Vehicle reference referring to a Car object (Upcasting)
        Vehicle v2 = new Car();
        v2.run(); // JVM checks the actual object type at runtime. Since it's a Car object,
                  // the overridden method in the Car class is executed.
    }
}
