package com.oca.oops.inheritance;

/**
 * Mid-level class in the 3-level hierarchy: Animal -> Dog -> Labrador.
 *
 * Demonstrates:
 * 1. Extending a superclass with 'extends'.
 * 2. Calling the parent constructor via super().
 * 3. Overriding a parent method AND calling the parent version with super.method().
 */
public class Dog extends Animal {

    String breed;

    public Dog(String name, String breed) {
        super(name); // Must be the first statement; calls Animal(String name)
        this.breed = breed;
        System.out.println("A Dog has been created: " + name + " (breed: " + breed + ")");
    }

    public void fetch() {
        System.out.println(name + " is fetching a ball!");
    }

    /**
     * Overrides Animal's makeSound().
     * Uses super.makeSound() to call the parent version first,
     * then adds Dog-specific behaviour on top.
     * This is the typical pattern when you want to extend (not replace) parent behaviour.
     */
    @Override
    public void makeSound() {
        super.makeSound(); // Calls Animal's makeSound() -> "Max makes a sound."
        System.out.println(name + " also says: Woof!");
    }

    public static void main(String[] args) {
        System.out.println("--- 3-Level Hierarchy: Animal -> Dog -> Labrador ---");
        Dog myDog = new Dog("Rex", "German Shepherd");
        myDog.eat();        // inherited from Animal
        myDog.makeSound();  // overridden: calls super first, then Dog version
        myDog.fetch();      // Dog-specific

        System.out.println("\n--- super.method() vs override ---");
        Animal ref = new Dog("Buddy", "Beagle"); // Upcasting
        ref.makeSound(); // Runtime polymorphism: Dog's makeSound() is called
    }
}
