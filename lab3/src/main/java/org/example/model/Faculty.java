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
}