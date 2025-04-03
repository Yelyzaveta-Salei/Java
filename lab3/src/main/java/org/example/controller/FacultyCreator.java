package org.example.controller;

import org.example.model.Department;
import org.example.model.Faculty;
import org.example.model.Human;

public class FacultyCreator {
    // Create a new faculty with the specified name and dean
    public static Faculty createFaculty(String name, Human dean) {
        return new Faculty(name, dean); // Create a faculty with a name and dean
    }

    // Add a department to the specified faculty
    public static void addDepartmentToFaculty(Faculty faculty, Department department) {
        faculty.addDepartment(department); // Connect the department to the faculty
    }
}