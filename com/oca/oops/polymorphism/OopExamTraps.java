package com.oca.oops.polymorphism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * OCA EXAM TRAPS — Three concepts that are frequently tested and commonly confused.
 *
 * TRAP 1: Static Method Hiding (NOT overriding)
 * TRAP 2: Field Hiding (NOT polymorphic)
 * TRAP 3: Immutable Objects
 *
 * ============================================================
 * TRAP 1 — STATIC METHOD HIDING
 * ============================================================
 * Static methods belong to the CLASS, not to an instance.
 * They CANNOT be overridden — they are HIDDEN.
 *
 * KEY RULE: Which static method runs is determined by the REFERENCE TYPE
 *           (compile time), NOT the actual object type (runtime).
 *           This is the OPPOSITE of instance method overriding.
 *
 * Contrast:
 *   Instance method → runtime polymorphism → object type decides
 *   Static method   → compile-time hiding  → reference type decides
 */
class Vehicle {

    // Static method in parent
    public static String getType() {
        return "Vehicle (static - from Vehicle class)";
    }

    // Instance method in parent
    public String describe() {
        return "I am a Vehicle instance";
    }
}

class Car extends Vehicle {

    // This HIDES Vehicle.getType() — it does NOT override it.
    // @Override would cause a compile error here.
    public static String getType() {
        return "Car (static - from Car class)";
    }

    // This OVERRIDES Vehicle.describe() — runtime polymorphism applies.
    @Override
    public String describe() {
        return "I am a Car instance";
    }
}

// ============================================================
// TRAP 2 — FIELD HIDING
// ============================================================
// Fields are NOT polymorphic. When a subclass declares a field with the
// same name as a parent field, the subclass field HIDES the parent field.
//
// KEY RULE: Which field is accessed is determined by the REFERENCE TYPE
//           (compile time), NOT the actual object type.
//
// This applies to both instance fields and static fields.
class ParentClass {
    String label = "Parent label";        // instance field
    static String category = "Parent category"; // static field
}

class ChildClass extends ParentClass {
    // This HIDES ParentClass.label (does NOT override — fields can't be overridden)
    String label = "Child label";
    static String category = "Child category";
}

// ============================================================
// TRAP 3 — IMMUTABLE OBJECTS
// ============================================================
// An immutable object's state cannot change after construction.
// Recipe:
//   1. Declare the class 'final' (prevents subclassing that could break immutability)
//   2. Make all fields 'private final'
//   3. No setter methods
//   4. Initialize all fields in the constructor
//   5. For mutable fields (e.g. List, Date), store a defensive copy in the constructor
//      and return a defensive copy from the getter (never expose the original)
final class ImmutableOrder {

    private final int orderId;
    private final String customerName;
    // Mutable field — must be defensively copied to preserve immutability
    private final List<String> items;

    public ImmutableOrder(int orderId, String customerName, List<String> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        // Defensive copy on the way IN — changes to the caller's list won't affect us
        this.items = new ArrayList<>(items);
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }

    // Defensive copy on the way OUT — caller cannot modify our internal list
    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }
}

// ============================================================
// MAIN — Demonstrates all three traps
// ============================================================
public class OopExamTraps {

    public static void main(String[] args) {

        // ---- TRAP 1: Static method hiding ----
        System.out.println("=== TRAP 1: Static Method Hiding vs Instance Overriding ===");

        Car car = new Car();
        Vehicle vehicleRefToCar = new Car(); // reference type = Vehicle, object = Car

        // Static method: REFERENCE TYPE decides (hiding)
        System.out.println(Vehicle.getType());          // "Vehicle ..."  (reference is Vehicle)
        System.out.println(Car.getType());              // "Car ..."      (reference is Car)
        System.out.println(vehicleRefToCar.getType());  // "Vehicle ..."  ← TRAP: reference is Vehicle!
        //                                                 Even though the object is a Car,
        //                                                 the static method of Vehicle runs.

        // Instance method: OBJECT TYPE decides (overriding / polymorphism)
        System.out.println(vehicleRefToCar.describe()); // "I am a Car instance" ← runtime dispatch
        //                                                 Object is Car, so Car's describe() runs.

        System.out.println();

        // ---- TRAP 2: Field hiding ----
        System.out.println("=== TRAP 2: Field Hiding (fields are NOT polymorphic) ===");

        ChildClass child = new ChildClass();
        ParentClass parentRefToChild = new ChildClass(); // reference = Parent, object = Child

        // Fields: REFERENCE TYPE decides (hiding)
        System.out.println(child.label);             // "Child label"  (reference is ChildClass)
        System.out.println(parentRefToChild.label);  // "Parent label" ← TRAP: reference is ParentClass!
        //                                              Even though the object is ChildClass,
        //                                              the parent's field is accessed.

        System.out.println(ChildClass.category);     // "Child category"
        System.out.println(ParentClass.category);    // "Parent category"
        System.out.println(parentRefToChild.category); // "Parent category" ← reference type wins

        System.out.println();

        // ---- TRAP 3: Immutable objects ----
        System.out.println("=== TRAP 3: Immutable Objects ===");

        List<String> originalItems = new ArrayList<>();
        originalItems.add("Laptop");
        originalItems.add("Mouse");

        ImmutableOrder order = new ImmutableOrder(101, "Alice", originalItems);

        // Modifying the original list after creation does NOT affect the immutable object
        originalItems.add("Keyboard"); // tampering with the source list
        System.out.println("Original list size: " + originalItems.size()); // 3
        System.out.println("Order items size:   " + order.getItems().size()); // 2 ← defensive copy protects us

        // The returned list is unmodifiable — trying to add throws UnsupportedOperationException
        try {
            order.getItems().add("Monitor"); // attempt to mutate returned list
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot mutate returned list: UnsupportedOperationException caught");
        }

        System.out.println("Order: #" + order.getOrderId()
                + ", Customer: " + order.getCustomerName()
                + ", Items: " + order.getItems());
    }
}
