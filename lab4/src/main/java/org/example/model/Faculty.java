package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name; // Faculty name
    private Human head; // Dean of the faculty
    private List<Department> departments; // Departments in the faculty

    // Constructor for Faculty
    public Faculty(String name, Human head) {
        this.name = name; // Initialize name
        this.head = head; // Initialize dean
        this.departments = new ArrayList<>(); // Initialize department list
    }

    // Add a department
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Get faculty name
    public String getName() {
        return name;
    }

    // Get dean
    public Human getHead() {
        return head;
    }

    // Get departments
    public List<Department> getDepartments() {
        return departments;
    }

    // String representation of Faculty
    @Override
    public String toString() {
        return "Faculty: " + name + ", Dean: " + head + ", Departments: " + departments;
    }

    // Compare Faculty objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(head, faculty.head) &&
                Objects.equals(departments, faculty.departments);
    }

    // Generate hash code for Faculty
    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }
}