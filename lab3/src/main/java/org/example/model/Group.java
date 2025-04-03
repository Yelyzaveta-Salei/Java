package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private String name; // Group name
    private Human head; // Group leader
    private List<Student> students; // List of students

    // Constructor for Group
    public Group(String name, Human head) {
        this.name = name; // Set the group name
        this.head = head; // Appoint the group leader
        this.students = new ArrayList<>(); // Initialize an empty list of students
    }

    // Add a student to the group
    public void addStudent(Student student) {
        students.add(student);
    }

    // Get the group's name
    public String getName() {
        return name;
    }

    // Get the list of students
    public List<Student> getStudents() {
        return students;
    }
}