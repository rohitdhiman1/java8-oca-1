package com.oca.oops.polymorphism;

import java.util.Objects;

/**
 * Demonstrates overriding Object class methods: toString() and equals().
 *
 * Every class in Java implicitly extends java.lang.Object.
 * Object provides default implementations of toString(), equals(), and hashCode()
 * which are almost always overridden in real classes.
 *
 * OCA Exam focus:
 * - Default toString() returns className@hexHashCode (rarely useful)
 * - Default equals() checks reference equality (same as ==), not value equality
 * - Overriding equals() should also override hashCode() (contract rule)
 */
class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Override toString() to return a meaningful string representation.
     * Without this, System.out.println(product) would print something like:
     *   com.oca.oops.polymorphism.Product@1b6d3586
     */
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }

    /**
     * Override equals() to compare by value (name + price), not by reference.
     * Without this, two Product objects with the same data would NOT be equal
     * because the default equals() uses == (reference comparison).
     *
     * Contract:
     * - Reflexive:  x.equals(x) must be true
     * - Symmetric:  x.equals(y) == y.equals(x)
     * - Transitive: if x.equals(y) and y.equals(z), then x.equals(z)
     * - Null-safe:  x.equals(null) must return false (never throw NPE)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;          // same reference, definitely equal
        if (obj == null) return false;         // null is never equal
        if (!(obj instanceof Product)) return false; // different type, not equal
        Product other = (Product) obj;         // safe downcast after instanceof check
        return Double.compare(this.price, other.price) == 0
                && Objects.equals(this.name, other.name);
    }

    /**
     * Always override hashCode() when you override equals().
     * Objects that are equal must have the same hashCode (required for HashMap/HashSet).
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

public class ObjectMethods {

    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 999.99);
        Product p2 = new Product("Laptop", 999.99); // same data, different object
        Product p3 = new Product("Phone", 499.99);

        // --- toString() ---
        System.out.println("--- toString() ---");
        System.out.println(p1); // calls p1.toString() automatically
        System.out.println(p2);
        System.out.println(p3);

        // --- equals() ---
        System.out.println("\n--- equals() ---");
        System.out.println("p1 == p2 (reference): " + (p1 == p2));       // false (different objects)
        System.out.println("p1.equals(p2) (value): " + p1.equals(p2));   // true  (same name+price)
        System.out.println("p1.equals(p3): " + p1.equals(p3));           // false (different data)
        System.out.println("p1.equals(null): " + p1.equals(null));       // false (null-safe)
        System.out.println("p1.equals(\"hello\"): " + p1.equals("hello")); // false (different type)

        // --- hashCode() consistency ---
        System.out.println("\n--- hashCode() ---");
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("Equal objects have same hashCode: " + (p1.hashCode() == p2.hashCode()));
        System.out.println("p3.hashCode(): " + p3.hashCode()); // different
    }
}
