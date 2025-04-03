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

    // Override toString for detailed department representation
    @Override
    public String toString() {
        return "Department: " + name + ", Head: " + head + ", Groups: " + groups;
    }

    // Override equals to compare Department objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(groups, that.groups);
    }

    // Override hashCode for consistent hashing of Department objects
    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }
}