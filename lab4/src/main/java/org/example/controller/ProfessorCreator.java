package org.example.controller;

import org.example.model.*;

public class ProfessorCreator {
    // Create a new professor with the specified attributes and department
    public static Professor createProfessor(String lastName, String firstName, String middleName, Gender gender, Department department) {
        return new Professor(lastName, firstName, middleName, gender, department); // Instantiate a new professor
    }
}