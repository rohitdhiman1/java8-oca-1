package com.oca.oops.inheritance;

/**
 * Bottom of the 3-level hierarchy: Animal -> Dog -> Labrador.
 *
 * This class extends Dog (not Animal directly), completing the chain:
 *   Animal (grandparent)
 *     └── Dog (parent)     -- adds breed, fetch(), overrides makeSound() with super call
 *           └── Labrador   -- adds color, swim(), overrides makeSound() again
 *
 * Constructor chain when new Labrador("Max", "Golden") is called:
 *   Labrador() -> Dog("Max", "Labrador") -> Animal("Max") -> Object()
 *   Then constructors complete in reverse: Object -> Animal -> Dog -> Labrador
 */
public class Labrador extends Dog {

    String color;

    // super() calls Dog(String name, String breed). Breed is fixed as "Labrador".
    public Labrador(String name, String color) {
        super(name, "Labrador"); // Calls Dog(String name, String breed)
        this.color = color;
        System.out.println("A Labrador has been created: " + name);
    }

    // Labrador-specific method (fetch() is already inherited from Dog)
    public void swim() {
        System.out.println(name + " is swimming!");
    }

    public void displayColor() {
        System.out.println(name + "'s color is " + color);
    }

    // Overrides Dog's makeSound() which itself overrides Animal's makeSound().
    // Note: we do NOT call super.makeSound() here — we fully replace Dog's version.
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof! (Labrador bark)");
    }

    public static void main(String[] args) {
        System.out.println("--- Full 3-Level Chain Constructor Output ---");
        Labrador myLab = new Labrador("Max", "Golden");
        // Expected output order: Animal -> Dog -> Labrador constructors

        System.out.println("\n--- Inherited + Overridden Methods ---");
        myLab.eat();          // inherited from Animal (2 levels up)
        myLab.makeSound();    // Labrador's own override
        myLab.fetch();        // inherited from Dog (1 level up)
        myLab.swim();         // Labrador-specific
        myLab.displayColor(); // Labrador-specific

        System.out.println("\n--- Polymorphism across 3 levels ---");
        Animal a = new Labrador("Buddy", "Black"); // Upcasting to grandparent
        a.eat();        // Animal's eat()
        a.makeSound();  // Labrador's makeSound() — runtime polymorphism resolves to most specific
    }
}
