package com.oca.oops.abstraction;

/**
 * An interface is a completely abstract "class" that is used to group related methods with empty bodies.
 * It represents a "contract" that implementing classes must adhere to.
 * By default, all methods in an interface are public and abstract.
 * By default, all fields in an interface are public, static, and final.
 */
public interface Drawable {

    // A constant (public, static, final by default)
    String DEFAULT_COLOR = "Black";

    // An abstract method (public, abstract by default)
    void draw();

    // A default method (introduced in Java 8)
    // It provides a default implementation, which can be overridden by implementing classes.
    default void erase() {
        System.out.println("Erasing the drawing.");
    }

    // A static method (introduced in Java 8)
    // It can be called directly on the interface, without needing an instance.
    static void getInfo() {
        System.out.println("This is a Drawable interface for 2D shapes.");
    }
}

/**
 * A class that implements the Drawable interface.
 * It must provide an implementation for the 'draw' method.
 */
class Square implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing a square with color " + DEFAULT_COLOR);
    }

    // Optionally, we can override the default method.
    @Override
    public void erase() {
        System.out.println("Erasing the square.");
    }

    public static void main(String[] args) {
        // Calling the static method on the interface
        Drawable.getInfo();

        Square mySquare = new Square();
        mySquare.draw();
        mySquare.erase();

        System.out.println("--- Polymorphism with Interfaces ---");
        // A Drawable reference can hold a Square object
        Drawable drawable = new Square();
        drawable.draw();
        drawable.erase();
    }
}
