package com.oca.statics;

/**
 * This class demonstrates the use of the 'static' keyword.
 * Static members (fields and methods) belong to the class itself, rather than to any specific instance (object).
 */
public class StaticExample {

    // A static field (class variable). There is only one copy of this variable, shared among all instances of the class.
    public static int objectCount = 0;

    // An instance field. Each object will have its own copy of this variable.
    public String instanceName;

    public StaticExample(String instanceName) {
        this.instanceName = instanceName;
        objectCount++; // Increment the static counter each time a new object is created.
        System.out.println("Created instance: " + instanceName + ". Total objects: " + objectCount);
    }

    // A static method (class method). It can be called directly on the class without creating an instance.
    // Static methods can only access static members directly. They cannot access instance members (like 'instanceName').
    public static void displayObjectCount() {
        System.out.println("Current object count from static method: " + objectCount);
        // System.out.println(instanceName); // This would cause a compile error.
    }

    // An instance method. It can access both static and instance members.
    public void displayInfo() {
        System.out.println("Instance Name: " + this.instanceName);
        System.out.println("Object Count (from instance method): " + objectCount);
    }

    // A static block. It is executed once when the class is loaded into memory, before any objects are created.
    static {
        System.out.println("Static block executed. This happens only once.");
        // We can initialize static variables here.
        objectCount = 0;
    }

    public static void main(String[] args) {
        // We can call the static method before creating any objects.
        StaticExample.displayObjectCount();

        System.out.println("--- Creating objects ---");
        StaticExample obj1 = new StaticExample("Object 1");
        StaticExample obj2 = new StaticExample("Object 2");
        new StaticExample("Object 3");

        System.out.println("--- Calling methods ---");
        // Call instance methods on specific objects
        obj1.displayInfo();
        obj2.displayInfo();

        // Call the static method again. It can be called on the class or an instance.
        StaticExample.displayObjectCount(); // Recommended way

        // We can access the static field directly.
        System.out.println("Accessing static field directly: StaticExample.objectCount = " + StaticExample.objectCount);
    }
}
