package org.example;

import org.example.controller.*;
import org.example.model.*;

public class Run {
    public static void main(String[] args) {
        Human rector = new Human("John", "Smith", "Friedrich", Gender.MALE);  // Create rector and university
        University university = UniversityCreator.createUniversity("Тесh University", rector);

        Human dean = new Human("Emily", "Johnson", "Michelle", Gender.FEMALE); // Create faculty and dean
        Faculty faculty = FacultyCreator.createFaculty("Faculty of Information Technology", dean);
        UniversityCreator.addFacultyToUniversity(university, faculty);

        Human headOfDepartment = new Human("Michael", "Brown", "Anthony", Gender.MALE); // Create department head
        Department department = DepartmentCreator.createDepartment("Software Engineering", headOfDepartment);
        FacultyCreator.addDepartmentToFaculty(faculty, department);

        Human groupHead = new Human("Maria", "Williams", "Laura", Gender.FEMALE); // Create group and leader
        Group group = GroupCreator.createGroup("IT-2021-2", groupHead);
        DepartmentCreator.addGroupToDepartment(department, group);

        Student student1 = StudentCreator.createStudent("James", "Taylor", "Oliver", Gender.MALE);  // Create students
        Student student2 = StudentCreator.createStudent("Olivia", "Jones", "Isabella", Gender.FEMALE);

        GroupCreator.addStudentToGroup(group, student1); // Add students to group
        GroupCreator.addStudentToGroup(group, student2);

        System.out.println(university.getName()); // Display all information about the structure
        for (Faculty f : university.getFaculties()) {
            System.out.println(f.getName());
            for (Department d : f.getDepartments()) {
                System.out.println("Department " + d.getName());
                for (Group g : d.getGroups()) {
                    System.out.println("Group: " + g.getName());
                    for (Student s : g.getStudents()) {
                        System.out.println("Student: " + s.getFullName());
                    }
                }
            }
        }
    }
}