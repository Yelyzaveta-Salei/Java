package org.example.controller;

import org.example.model.Gender;
import org.example.model.Student;

public class StudentCreator {
    // Create a new student with the specified attributes
    public static Student createStudent(String lastName, String firstName, String middleName, Gender gender) {
        return new Student(lastName, firstName, middleName, gender); // Instantiate a new student
    }
}