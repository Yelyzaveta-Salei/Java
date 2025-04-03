package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name; // Department name
    private Human head; // Head of the department
    private List<Group> groups; // Groups in the department

    // Constructor initializes the department with a name and head
    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.groups = new ArrayList<>(); // Initialize empty list for groups
    }

    // Add a group to the department
    public void addGroup(Group group) {
        groups.add(group);
    }

    // Get the department's name
    public String getName() {
        return name;
    }

    // Get the head of the department
    public Human getHead() {
        return head;
    }

    // Get the list of groups in the department
    public List<Group> getGroups() {
        return groups;
    }
}