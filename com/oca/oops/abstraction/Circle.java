package com.oca.oops.abstraction;

/**
 * This is a concrete class that extends the abstract Shape class.
 * It must provide an implementation for all abstract methods from the superclass.
 */
public class Circle extends Shape {

    double radius;

    public Circle(String color, double radius) {
        // Call the superclass constructor
        super(color);
        this.radius = radius;
        System.out.println("Circle constructor called.");
    }

    // Implementation of the abstract method from the Shape class
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        // We can create an instance of a concrete subclass
        Circle myCircle = new Circle("Red", 5.0);

        System.out.println("Color of the circle: " + myCircle.getColor());
        System.out.println("Area of the circle: " + myCircle.getArea());

        System.out.println("--- Polymorphism with Abstract Classes ---");
        // A Shape reference can hold a Circle object
        Shape shape1 = new Circle("Blue", 10.0);
        System.out.println("Area of shape1 (which is a Circle): " + shape1.getArea());
    }
}
