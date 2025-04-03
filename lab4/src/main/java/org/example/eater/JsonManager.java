package org.example.eater;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Human;
import org.example.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final String FILE_PATH = "university.json"; // Path to the JSON file

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Human.class, new HumanAdapter()) // Custom adapter for Human class
            .setPrettyPrinting() // Enable pretty printing for JSON
            .create();

    // Save University object to JSON file
    public static void saveToJson(University university) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(university, University.class, writer);
            System.out.println("University saved to JSON file.");
        } catch (IOException e) {
            System.err.println("Error saving to JSON: " + e.getMessage());
        }
    }

    // Load University object from JSON file
    public static University loadFromJson() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            System.err.println("Error loading from JSON: " + e.getMessage());
            return null;
        }
    }
}