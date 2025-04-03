package org.example.database;

import org.example.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    // H2 database connection details
    private static final String URL = "jdbc:h2:./students_db";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String SCHEMA_FILE = "src/main/resources/database/schema.sql";

    // Initialize the database using SQL schema file
    public static void initDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = readSqlFile(SCHEMA_FILE); // Read and execute schema
            statement.execute(sql);
            System.out.println("Database initialized from schema.sql.");

        } catch (SQLException | IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }

    // Read SQL file and return its content as a string
    private static String readSqlFile(String filePath) throws IOException {
        StringBuilder sql = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }
        }
        return sql.toString();
    }

    // Get students born in a specified month
    public static List<Student> getStudentsBornInMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE MONTH(birth_date) = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, month); // Set query parameter
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) { // Process result set
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getDate("birth_date").toString(),
                        resultSet.getString("record_book_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions
        }
        return students; // Return filtered students
    }
}