package com.oca.casting;

/**
 * This class demonstrates reference type casting (upcasting, downcasting)
 * and the instanceof operator.
 */

// Simple hierarchy for demonstration
class Animal {
    public void eat() {
        System.out.println("  Animal is eating");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("  Dog is barking");
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println("  Cat is meowing");
    }
}

// Interface for casting demo
interface Swimmable {
    void swim();
}

class Labrador extends Dog implements Swimmable {
    @Override
    public void swim() {
        System.out.println("  Labrador is swimming");
    }
}

public class ReferenceCasting {

    public static void main(String[] args) {
        // 1. Upcasting - subclass to superclass (implicit, always safe)
        System.out.println("--- Upcasting (Implicit) ---");
        Dog dog = new Dog();
        Animal animal = dog; // Upcasting: Dog -> Animal (no cast needed)
        animal.eat();        // OK - Animal has eat()
        // animal.bark();    // COMPILE ERROR - Animal reference can't see Dog methods
        System.out.println("Dog upcasted to Animal successfully");

        // 2. Downcasting - superclass to subclass (explicit, can fail at runtime)
        System.out.println("\n--- Downcasting (Explicit) ---");
        Animal animalRef = new Dog(); // The actual object is a Dog
        Dog dogRef = (Dog) animalRef; // Downcasting: Animal -> Dog (cast required)
        dogRef.bark(); // OK - now we can access Dog methods
        dogRef.eat();  // OK - inherited from Animal
        System.out.println("Animal downcasted to Dog successfully");

        // 3. ClassCastException - downcasting to wrong type
        System.out.println("\n--- ClassCastException ---");
        Animal animalRef2 = new Cat(); // The actual object is a Cat
        try {
            Dog wrongCast = (Dog) animalRef2; // Compiles, but fails at runtime!
            wrongCast.bark();
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException: " + e.getMessage());
        }

        // 4. Using instanceof to check before casting
        System.out.println("\n--- instanceof Operator ---");
        Animal[] animals = { new Dog(), new Cat(), new Labrador() };
        for (Animal a : animals) {
            System.out.println(a.getClass().getSimpleName() + ":");
            if (a instanceof Dog) {
                Dog d = (Dog) a; // Safe - we checked first
                d.bark();
            }
            if (a instanceof Cat) {
                Cat c = (Cat) a; // Safe - we checked first
                c.meow();
            }
            if (a instanceof Swimmable) {
                Swimmable s = (Swimmable) a;
                s.swim();
            }
        }

        // 5. instanceof with inheritance chain
        System.out.println("\n--- instanceof and Inheritance ---");
        Labrador lab = new Labrador();
        System.out.println("lab instanceof Labrador: " + (lab instanceof Labrador)); // true
        System.out.println("lab instanceof Dog: " + (lab instanceof Dog));           // true
        System.out.println("lab instanceof Animal: " + (lab instanceof Animal));     // true
        System.out.println("lab instanceof Swimmable: " + (lab instanceof Swimmable)); // true
        System.out.println("lab instanceof Object: " + (lab instanceof Object));     // true

        // 6. null and instanceof
        System.out.println("\n--- null instanceof ---");
        Dog nullDog = null;
        System.out.println("null instanceof Dog: " + (nullDog instanceof Dog)); // Always false
        System.out.println("null instanceof Object: " + (null instanceof Object)); // Always false

        // 7. Casting with interfaces
        System.out.println("\n--- Casting with Interfaces ---");
        Swimmable swimmer = new Labrador(); // Upcasting to interface
        swimmer.swim();
        // swimmer.bark(); // COMPILE ERROR - Swimmable doesn't have bark()
        Labrador labFromSwimmer = (Labrador) swimmer; // Downcast from interface
        labFromSwimmer.bark(); // Now we can access Labrador methods
        System.out.println("Successfully cast Swimmable to Labrador");
    }
}
