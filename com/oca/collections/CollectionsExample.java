package com.oca.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class demonstrates the basic usage of common collections from the Java Collections Framework.
 */
public class CollectionsExample {

    public static void main(String[] args) {
        // 1. List: An ordered collection that allows duplicate elements.
        // ArrayList is the most common implementation.
        System.out.println("--- List (ArrayList) ---");
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Cherry");
        fruitList.add("Apple"); // Duplicates are allowed

        System.out.println("Fruits: " + fruitList);
        System.out.println("Element at index 1: " + fruitList.get(1));
        System.out.println("Size of the list: " + fruitList.size());

        // Iterating over a list
        for (String fruit : fruitList) {
            System.out.println("- " + fruit);
        }

        // LinkedList is another implementation, efficient for additions/removals.
        List<String> animalList = new LinkedList<>();
        animalList.add("Lion");
        animalList.add("Tiger");
        System.out.println("\nAnimals (LinkedList): " + animalList);


        // 2. Set: A collection that contains no duplicate elements.
        // HashSet is the most common implementation, it does not guarantee order.
        System.out.println("\n--- Set (HashSet) ---");
        Set<String> uniqueColors = new HashSet<>();
        uniqueColors.add("Red");
        uniqueColors.add("Green");
        uniqueColors.add("Blue");
        uniqueColors.add("Red"); // This duplicate will be ignored

        System.out.println("Unique Colors: " + uniqueColors);
        System.out.println("Does the set contain 'Green'? " + uniqueColors.contains("Green"));


        // 3. Map: An object that maps keys to values. A map cannot contain duplicate keys.
        // HashMap is the most common implementation.
        System.out.println("\n--- Map (HashMap) ---");
        Map<String, Integer> cityPopulations = new HashMap<>();
        cityPopulations.put("New York", 8400000);
        cityPopulations.put("Tokyo", 13900000);
        cityPopulations.put("London", 8900000);
        cityPopulations.put("New York", 8500000); // This will update the existing value for the key "New York"

        System.out.println("City Populations: " + cityPopulations);
        System.out.println("Population of London: " + cityPopulations.get("London"));

        // Iterating over a map
        System.out.println("Iterating over map entries:");
        for (Map.Entry<String, Integer> entry : cityPopulations.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
