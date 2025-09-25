package com.oca.exceptions;

/**
 * This is a custom exception class. It extends one of Java's exception classes.
 * Extend 'Exception' for a checked exception (must be handled or declared).
 * Extend 'RuntimeException' for an unchecked exception.
 */
public class CustomException extends Exception {

    // Constructor that accepts a message
    public CustomException(String message) {
        super(message); // Call the constructor of the parent Exception class
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) throws CustomException {
        if (amount < 0) {
            // Throw our custom exception for an invalid (negative) amount
            throw new CustomException("Withdrawal amount cannot be negative.");
        }
        if (amount > balance) {
            // Throw our custom exception for insufficient funds
            throw new CustomException("Insufficient funds. Current balance is " + balance);
        }
        balance -= amount;
        System.out.println("Successfully withdrew " + amount + ". New balance is " + balance);
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);

        try {
            System.out.println("Attempting to withdraw 500...");
            myAccount.withdraw(500); // This should succeed

            System.out.println("\nAttempting to withdraw 600...");
            myAccount.withdraw(600); // This should fail with insufficient funds

        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--------------------\n");

        try {
            System.out.println("Attempting to withdraw -100...");
            myAccount.withdraw(-100); // This should fail with a negative amount
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
