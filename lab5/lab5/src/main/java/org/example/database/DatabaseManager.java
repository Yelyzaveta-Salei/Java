package org.example.database;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/students"; // JDBC URL for connecting to PostgreSQL
    private static final String USER = "user"; // Database username
    private static final String PASSWORD = "password"; // Database password

    // Method for initializing the database connection
    public static void initDatabase() {
        System.out.println("Database connection initialized");
    }

    // Method to retrieve all students from the database
    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>(); // Create a new list to hold student objects
        String query = "SELECT * FROM students"; // SQL query to select all students from the table

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); // Establish connection to the database
             Statement statement = connection.createStatement(); // Create a statement to execute the query
             ResultSet resultSet = statement.executeQuery(query)) { // Execute the query and obtain the result set

            while (resultSet.next()) { // Iterate through each row in the result set
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getDate("birth_date").toString(),
                        resultSet.getString("record_book_number")
                )); // Add each student's data to the list
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQL exception occurs
        }
        return students; // Return the list of students
    }
}
