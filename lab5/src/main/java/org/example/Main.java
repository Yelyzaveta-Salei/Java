package org.example;

import org.example.database.DatabaseManager;
import org.example.model.Student;

import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Initialize the database connection
        DatabaseManager.initDatabase();

        // Create a Scanner object to capture user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month number (1-12): ");
        int month = scanner.nextInt(); // Read user input for the month

        // Define the date format to parse birthdate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        List<Student> students = DatabaseManager.getStudentsBornInMonth(month);

        if (students.isEmpty()) {
            System.out.println("No students found for the specified month.");
        } else {
            System.out.println("Filtered student data:");
            students.forEach(System.out::println);
        }
        scanner.close(); // Close the scanner
    }
}