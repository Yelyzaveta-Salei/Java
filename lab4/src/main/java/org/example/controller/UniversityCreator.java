package org.example.controller;

import org.example.model.*;

public class UniversityCreator {
    // Create a new university with the specified name and rector
    public static University createUniversity(String name, Human rector) {
        return new University(name, rector); // Establish a new university
    }

    // Add a faculty to the specified university
    public static void addFacultyToUniversity(University university, Faculty faculty) {
        university.addFaculty(faculty); // Attach the faculty to the university
    }
}