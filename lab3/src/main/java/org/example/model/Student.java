package org.example.model;

public class Student extends Human {
    // Constructor for Student
    public Student(String lastName, String firstName, String middleName, Gender gender) {
        super(firstName, lastName, middleName, gender); // Pass all data to the parent class
    }

    // We do not override getFullName() because it is already defined in the parent class.
    // It can be used directly in this class.

    // Example of adding additional methods specific to Student
    public String getStudentInfo() {
        return "Student: " + getFullName() + ", Gender: " + getGender();
    }
}