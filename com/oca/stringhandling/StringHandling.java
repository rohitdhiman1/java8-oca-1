package com.oca.stringhandling;

/**
 * This class demonstrates common methods for String manipulation.
 * Strings are immutable in Java, meaning their state cannot be changed after creation.
 * Every manipulation method creates a new String object.
 */
public class StringHandling {

    public static void main(String[] args) {
        String text = "  Hello, World!  ";

        System.out.println("Original String: '" + text + "'");

        // length() - returns the number of characters
        System.out.println("Length: " + text.length());

        // charAt(index) - returns the character at a specific index
        System.out.println("Character at index 3: " + text.charAt(3));

        // substring(beginIndex, endIndex) - extracts a part of the string
        String sub = text.substring(9, 14); // "World"
        System.out.println("Substring (9, 14): '" + sub + "'");

        // toUpperCase() / toLowerCase()
        System.out.println("Uppercase: '" + text.toUpperCase() + "'");
        System.out.println("Lowercase: '" + text.toLowerCase() + "'");

        // trim() - removes leading and trailing whitespace
        String trimmedText = text.trim();
        System.out.println("Trimmed: '" + trimmedText + "'");

        // startsWith(prefix) / endsWith(suffix)
        System.out.println("Starts with '  H': " + text.startsWith("  H")); // true
        System.out.println("Ends with '!  ': " + text.endsWith("!  "));   // true

        // replace(oldChar, newChar)
        String replacedText = trimmedText.replace('l', 'p');
        System.out.println("Replaced 'l' with 'p': '" + replacedText + "'");

        // split(regex) - splits the string into an array of strings
        String[] parts = trimmedText.split(", ");
        System.out.println("Split by ', ': " + java.util.Arrays.toString(parts));

        // equals(anotherString) vs ==
        // .equals() compares the actual content of the strings.
        // == compares the memory addresses (references).
        String s1 = "Java";
        String s2 = new String("Java");
        String s3 = "Java";

        System.out.println("\n--- String Comparison ---");
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true (content is the same)
        System.out.println("s1 == s2: " + (s1 == s2));         // false (different objects in memory)
        System.out.println("s1 == s3: " + (s1 == s3));         // true (s3 points to the same string literal in the pool as s1)

        // StringBuilder - for mutable string operations
        // Use this when you need to perform many modifications to a string.
        System.out.println("\n--- StringBuilder ---");
        StringBuilder sb = new StringBuilder("Start");
        sb.append("->Middle");
        sb.append("->End");
        sb.insert(5, " (inserted) ");
        System.out.println("StringBuilder result: " + sb.toString());
    }
}
