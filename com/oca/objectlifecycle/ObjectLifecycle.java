package com.oca.objectlifecycle;

/**
 * This class demonstrates object lifecycle and garbage collection eligibility in Java.
 * Objects become eligible for GC when no live thread can access them.
 */
public class ObjectLifecycle {

    private String name;

    // Reference for island of isolation demo
    ObjectLifecycle partner;

    public ObjectLifecycle(String name) {
        this.name = name;
        System.out.println("  Object created: " + name);
    }

    // finalize() is deprecated since Java 9 but still appears on the OCA exam
    @SuppressWarnings("deprecation")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("  finalize() called for: " + name);
        super.finalize();
    }

    @Override
    public String toString() {
        return "ObjectLifecycle(" + name + ")";
    }

    public static void main(String[] args) {
        // 1. Object creation with 'new' keyword
        System.out.println("--- Object Creation ---");
        ObjectLifecycle obj1 = new ObjectLifecycle("Alpha");
        System.out.println("obj1 refers to: " + obj1);

        // 2. Eligible for GC: nulling a reference
        System.out.println("\n--- GC Eligibility: Nulling Reference ---");
        ObjectLifecycle obj2 = new ObjectLifecycle("Beta");
        obj2 = null; // "Beta" is now eligible for GC
        System.out.println("obj2 set to null - 'Beta' is eligible for GC");

        // 3. Eligible for GC: reassigning a reference
        System.out.println("\n--- GC Eligibility: Reassigning Reference ---");
        ObjectLifecycle obj3 = new ObjectLifecycle("Gamma");
        ObjectLifecycle obj4 = new ObjectLifecycle("Delta");
        obj3 = obj4; // "Gamma" is now eligible for GC, both obj3 and obj4 point to "Delta"
        System.out.println("obj3 reassigned to obj4 - 'Gamma' is eligible for GC");

        // 4. Eligible for GC: objects created in methods go out of scope
        System.out.println("\n--- GC Eligibility: Method Scope ---");
        createLocalObject(); // Object created inside is eligible for GC after method returns
        System.out.println("After createLocalObject() - the local object is eligible for GC");

        // 5. Island of isolation - two objects reference each other but nothing else references them
        System.out.println("\n--- Island of Isolation ---");
        ObjectLifecycle island1 = new ObjectLifecycle("Island-A");
        ObjectLifecycle island2 = new ObjectLifecycle("Island-B");
        island1.partner = island2;
        island2.partner = island1;
        // Now remove external references
        island1 = null;
        island2 = null;
        // Both objects still reference each other, but no external reference can reach them.
        // They form an "island of isolation" and are eligible for GC.
        System.out.println("Both external references nulled - island of isolation is eligible for GC");

        // 6. System.gc() - a request (not a command) to run garbage collection
        System.out.println("\n--- System.gc() ---");
        System.out.println("Calling System.gc() - this is only a suggestion, JVM may ignore it");
        System.gc(); // No guarantee that finalize() will be called
        System.out.println("System.gc() returned - GC may or may not have run");

        // 7. How many objects are eligible for GC? (Common exam question pattern)
        System.out.println("\n--- Exam Question Pattern ---");
        Object a = new Object(); // Object 1
        Object b = new Object(); // Object 2
        Object c = a;            // c points to Object 1 (no new object)
        a = null;                // Object 1 still reachable via c
        b = null;                // Object 2 is now eligible for GC
        c = null;                // Object 1 is now eligible for GC
        System.out.println("After nulling a, b, c: 2 objects eligible for GC");
    }

    public static void createLocalObject() {
        ObjectLifecycle local = new ObjectLifecycle("LocalObj");
        System.out.println("  Inside method, local refers to: " + local);
        // 'local' goes out of scope when this method returns
    }
}
