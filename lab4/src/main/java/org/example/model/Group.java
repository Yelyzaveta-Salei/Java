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

    // String representation of Group
    @Override
    public String toString() {
        return "Group: " + name + ", Leader: " + head + ", Students: " + students;
    }

    // Compare Group objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(head, group.head) &&
                Objects.equals(students, group.students);
    }

    // Generate hash code for Group
    @Override
    public int hashCode() {
        return Objects.hash(name, head, students);
    }
}