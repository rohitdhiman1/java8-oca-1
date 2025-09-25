package com.oca.oops.inheritance;

/**
 * This is the derived or subclass (child class).
 * It inherits from the Animal class using the 'extends' keyword.
 */
public class Labrador extends Animal {

    String color;

    // The constructor of the subclass must call the constructor of the superclass.
    // 'super()' is used for this purpose and must be the first statement.
    public Labrador(String name, String color) {
        super(name); // Calls the Animal(String name) constructor
        this.color = color;
        System.out.println("A Labrador has been created: " + name);
    }

    // Labrador can have its own specific methods.
    public void fetch() {
        System.out.println(name + " is fetching a ball!");
    }

    // This is an example of Method Overriding.
    // The subclass provides a specific implementation for a method already defined in its superclass.
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }

    public void displayColor() {
        System.out.println(name + "'s color is " + color);
    }

    public static void main(String[] args) {
        // Create an instance of the subclass
        Labrador myLab = new Labrador("Max", "Golden");

        // Call methods inherited from the Animal class
        myLab.eat();

        // Call the overridden method
        myLab.makeSound();

        // Call methods specific to the Labrador class
        myLab.fetch();
        myLab.displayColor();
    }
}
