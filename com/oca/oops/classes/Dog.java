package com.oca.oops.classes;

/**
 * This class represents a simple blueprint for a Dog object.
 * It demonstrates the basic structure of a class with fields (state) and methods (behavior).
 */
public class Dog {

    // Fields (Instance Variables) - represent the state of an object
    String name;
    String breed;
    int age;

    // Constructor - a special method to initialize a new object
    public Dog(String name, String breed, int age) {
        System.out.println("Dog object created with name: " + name);
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    // Methods (Instance Methods) - represent the behavior of an object
    public void bark() {
        System.out.println(name + " says: Woof Woof!");
    }

    public void celebrateBirthday() {
        this.age++;
        System.out.println("Happy Birthday, " + name + "! You are now " + age + " years old.");
    }

    public String getDetails() {
        return "Name: " + name + ", Breed: " + breed + ", Age: " + age;
    }

    // main method to demonstrate creating and using Dog objects
    public static void main(String[] args) {
        // Create a Dog object (an instance of the Dog class)
        Dog myDog = new Dog("Buddy", "Golden Retriever", 3);

        // Access fields and call methods using the dot (.) operator
        System.out.println("My dog's details: " + myDog.getDetails());

        myDog.bark();
        myDog.celebrateBirthday();

        System.out.println("Updated details: " + myDog.getDetails());

        System.out.println("--------------------");

        // Create another Dog object
        Dog anotherDog = new Dog("Lucy", "Poodle", 5);
        System.out.println("Another dog's details: " + anotherDog.getDetails());
        anotherDog.bark();
    }
}
