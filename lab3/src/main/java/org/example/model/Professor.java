package org.example.model;

public class Professor extends Human {
    private Department department; // Department where the professor works

    // Constructor for Professor
    public Professor(String lastName, String firstName, String middleName, Gender gender, Department department) {
        super(firstName, lastName, middleName, gender); // Pass data to the Human superclass constructor
        this.department = department; // Assign the department
    }

    // Get the professor's department
    public Department getDepartment() {
        return department;
    }

    // Set the professor's department
    public void setDepartment(Department department) {
        this.department = department;
    }

}