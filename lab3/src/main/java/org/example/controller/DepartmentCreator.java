package org.example.controller;

import org.example.model.Department;
import org.example.model.Group;
import org.example.model.Human;

public class DepartmentCreator {
    // Method to create a new department
    public static Department createDepartment(String name, Human head) {
        return new Department(name, head); // Return a new department with name and head
    }

    // Method to add a group to a department
    public static void addGroupToDepartment(Department department, Group group) {
        department.addGroup(group); // Officially attach the group to the department
    }
}