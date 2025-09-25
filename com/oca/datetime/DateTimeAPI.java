package com.oca.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * This class demonstrates the Java 8 Date and Time API (java.time package).
 * This API is immutable and thread-safe.
 */
public class DateTimeAPI {

    public static void main(String[] args) {
        // 1. Creating Date and Time objects
        System.out.println("--- Creating Date/Time Objects ---");
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Creating a specific date
        LocalDate specificDate = LocalDate.of(2024, Month.DECEMBER, 25);
        System.out.println("Specific Date: " + specificDate);


        // 2. Getting information from date/time objects
        System.out.println("\n--- Accessing Date/Time Info ---");
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day of Month: " + today.getDayOfMonth());
        System.out.println("Hour: " + now.getHour());


        // 3. Manipulating Dates and Times
        // Since the objects are immutable, these methods return a new object.
        System.out.println("\n--- Manipulating Dates/Times ---");
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("Tomorrow: " + tomorrow);

        LocalDate lastMonth = today.minus(1, ChronoUnit.MONTHS);
        System.out.println("Date one month ago: " + lastMonth);


        // 4. Formatting Dates and Times
        System.out.println("\n--- Formatting ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime);


        // 5. Parsing a String into a Date
        System.out.println("\n--- Parsing ---");
        String dateString = "15/08/2023";
        DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(dateString, parseFormatter);
        System.out.println("Parsed Date: " + parsedDate);
        System.out.println("Day of the week of parsed date: " + parsedDate.getDayOfWeek());
    }
}
