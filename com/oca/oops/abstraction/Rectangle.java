package com.oca.oops.abstraction;

/**
 * Another concrete class that extends the abstract Shape class.
 */
public class Rectangle extends Shape {

    double length;
    double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
        System.out.println("Rectangle constructor called.");
    }

    // Implementation of the abstract method from the Shape class
    @Override
    public double getArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Shape shape2 = new Rectangle("Green", 4.0, 5.0);
        System.out.println("Area of shape2 (which is a Rectangle): " + shape2.getArea());
        System.out.println("Color of the rectangle: " + shape2.getColor());
    }
}
