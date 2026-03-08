package com.ocp.optional;

import java.util.Optional;

/**
 * This class demonstrates the use of java.util.Optional.
 * Optional is a container object which may or may not contain a non-null value.
 * It's designed to avoid NullPointerExceptions and to create more expressive APIs.
 */
public class OptionalExample {

    // A method that might return a null value.
    public static Optional<String> findUserById(int id) {
        if (id == 1) {
            return Optional.of("Alice"); // Value is present
        } else {
            return Optional.empty(); // Value is absent
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Searching for User 1 ---");
        Optional<String> user1 = findUserById(1);

        // 1. Checking for presence with isPresent()
        if (user1.isPresent()) {
            System.out.println("User found: " + user1.get()); // .get() retrieves the value
        } else {
            System.out.println("User not found.");
        }

        // 2. A more idiomatic way using ifPresent()
        // This lambda is only executed if the value is present.
        user1.ifPresent(name -> System.out.println("Found user with ifPresent: " + name));


        System.out.println("\n--- Searching for User 2 ---");
        Optional<String> user2 = findUserById(2);

        // 3. Providing a default value with orElse()
        // If user2 is empty, it will use the default value "Guest".
        String username = user2.orElse("Guest");
        System.out.println("Username is: " + username);


        // 4. Providing a default value with orElseGet()
        // The supplier is only called if the Optional is empty. This is more efficient
        // if creating the default value is an expensive operation.
        String usernameFromSupplier = user2.orElseGet(() -> {
            System.out.println("(Supplier called to create default value)");
            return "DefaultUser";
        });
        System.out.println("Username from orElseGet: " + usernameFromSupplier);


        // 5. Throwing an exception with orElseThrow()
        try {
            String foundUser = user2.orElseThrow(() -> new IllegalStateException("User not found"));
            System.out.println("This will not be printed: " + foundUser);
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }


        // 6. Transforming the value with map()
        // The map operation is only applied if the value is present.
        Optional<Integer> nameLength = user1.map(name -> name.length());
        nameLength.ifPresent(length -> System.out.println("\nLength of User 1's name: " + length));

        Optional<Integer> noNameLength = user2.map(String::length);
        System.out.println("Is length present for User 2? " + noNameLength.isPresent()); // false
    }
}
