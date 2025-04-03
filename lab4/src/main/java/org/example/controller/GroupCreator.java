package org.example.controller;

import org.example.model.*;

public class GroupCreator {
    // Create a new group with the specified name and leader
    public static Group createGroup(String name, Human head) {
        return new Group(name, head); // Form a new group with a name and leader
    }

    // Add a student to the specified group
    public static void addStudentToGroup(Group group, Student student) {
        group.addStudent(student); // Add the student to the group
    }
}