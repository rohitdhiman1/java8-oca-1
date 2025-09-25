package com.oca.oops.inheritance;

/**
 * This is the base or superclass (parent class).
 * It defines common state and behavior that can be inherited by subclasses.
 */
public class Animal {

    String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("An Animal has been created: " + name);
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }



    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }
}
