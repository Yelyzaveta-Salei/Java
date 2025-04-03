package org.example;

import org.example.database.DatabaseManager;
import org.example.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Initialize the database connection
        DatabaseManager.initDatabase();

        // Create a Scanner object to capture user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month number (1-12): ");
        int month = scanner.nextInt(); // Read user input for the month

        // Retrieve all student records from the database
        List<Student> allStudents = DatabaseManager.getAllStudents();

        // Define the date format to parse birth dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Filter students by the specified birth month
        List<Student> filteredStudents = allStudents.stream()
                .filter(student -> {
                    try {
                        LocalDate birthDate = LocalDate.parse(student.getBirthDate(), formatter); // Parse the birth date
                        return birthDate.getMonthValue() == month; // Check if the month matches
                    } catch (Exception e) {
                        System.err.println("Date parsing error: " + student.getBirthDate()); // Handle parsing errors
                        return false; // Skip students with invalid birth dates
                    }
                })
                .collect(Collectors.toList()); // Collect the filtered students into a list

        // Display the filtered results
        if (filteredStudents.isEmpty()) {
            System.out.println("No students found for the specified month.");
        } else {
            System.out.println("Filtered student data:");
            filteredStudents.forEach(System.out::println); // Print each student in the filtered list
        }
        scanner.close(); // Close the scanner
    }
}