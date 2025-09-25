package com.oca.oops.encapsulation;

/**
 * Encapsulation is the practice of bundling the data (fields) and the methods that operate on the data
 * into a single unit (a class). It also involves restricting direct access to some of an object's components.
 * This is typically achieved by making fields 'private' and providing 'public' methods (getters and setters)
 * to access and modify the data.
 */
public class Person {

    // Fields are declared as private to restrict direct access from outside the class.
    private String name;
    private int age;
    private String ssn; // Social Security Number

    // Public constructor
    public Person(String name, int age, String ssn) {
        // We can use setters here to ensure validation logic is applied upon creation.
        this.setName(name);
        this.setAge(age);
        this.ssn = ssn; // Assume SSN is valid for this example
    }

    // Public 'getter' method for the 'name' field.
    // It allows controlled, read-only access to the private field.
    public String getName() {
        return name;
    }

    // Public 'setter' method for the 'name' field.
    // It allows controlled modification of the private field, often with validation.
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Name cannot be null or empty.");
        }
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age > 0 && age < 130) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be between 1 and 129.");
        }
    }

    // We might choose not to provide a public setter for sensitive data like SSN,
    // making it effectively read-only after the object is created.
    public String getSsn() {
        // We could also add security here, e.g., return only the last 4 digits.
        return "xxx-xx-" + ssn.substring(ssn.length() - 4);
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name + ", Age: " + this.age + ", SSN (masked): " + this.getSsn());
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30, "123-45-6789");
        person1.displayInfo();

        // Direct access to private fields is not allowed and will cause a compile error.
        // person1.age = 31; // This line would not compile.

        // We must use the public setter method to modify the data.
        person1.setAge(31);
        System.out.println("Alice's new age: " + person1.getAge());

        // Trying to set an invalid age
        person1.setAge(-5); // This will print an error message.
        System.out.println("Alice's age after invalid attempt: " + person1.getAge()); // Age remains 31

        // Accessing the masked SSN
        System.out.println("SSN: " + person1.getSsn());
    }
}
