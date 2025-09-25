package com.oca.oops.abstraction;

/**
 * This is an abstract class.
 * It cannot be instantiated on its own.
 * It can have both abstract methods (without a body) and concrete methods (with a body).
 * It serves as a blueprint for other classes.
 */
public abstract class Shape {

    String color;

    // Concrete method
    public Shape(String color) {
        this.color = color;
        System.out.println("Shape constructor called. Color is " + color);
    }

    // Concrete method
    public String getColor() {
        return color;
    }

    // Abstract method - must be implemented by any concrete subclass.
    // It has no method body.
    public abstract double getArea();
}
