package org.example.eater;

import org.example.controller.*;
import org.example.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class Test {
    @org.junit.jupiter.api.Test
    public void testUniversityJsonSerialization() {
        // Create a test university
        Human rector = new Human("John", "Smith", "Friedrich", Gender.MALE);
        University oldUniversity = UniversityCreator.createUniversity("Tech University", rector);

        // Add faculties (1 faculty)
        Human dean = new Human("Emily", "Johnson", "Michelle", Gender.FEMALE);
        Faculty faculty = FacultyCreator.createFaculty("Faculty of Information Technology", dean);
        UniversityCreator.addFacultyToUniversity(oldUniversity, faculty);

        // Add departments to the faculty (1 department)
        Human headOfDepartment = new Human("Michael", "Brown", "Anthony", Gender.MALE);
        Department department = DepartmentCreator.createDepartment("Software Engineering", headOfDepartment);
        FacultyCreator.addDepartmentToFaculty(faculty, department);

        // Add groups to the department (1 group)
        Human groupHead = new Human("Maria", "Williams", "Laura", Gender.FEMALE);
        Group group = GroupCreator.createGroup("IT-2021-2", groupHead);
        DepartmentCreator.addGroupToDepartment(department, group);

        // Add students to the group (2 students)
        Student student1 = StudentCreator.createStudent("James", "Taylor", "Oliver", Gender.MALE);
        GroupCreator.addStudentToGroup(group, student1);

        Student student2 = StudentCreator.createStudent("Olivia", "Jones", "Isabella", Gender.FEMALE);
        GroupCreator.addStudentToGroup(group, student2);

        // Serialize the university to JSON
        System.out.println("Original University:");
        System.out.println(oldUniversity);
        JsonManager.saveToJson(oldUniversity);
        System.out.println("\nJSON file successfully saved.");

        // Deserialize the university from JSON
        University newUniversity = JsonManager.loadFromJson();
        System.out.println("\nRestored University:");
        System.out.println(newUniversity);

        // Verify results
        assertNotNull(newUniversity, "Error: newUniversity is null");
        assertEquals(oldUniversity, newUniversity, "Universities do not match");
        assertEquals(oldUniversity.toString(), newUniversity.toString(), "String representations of universities do not match");

        // Verify structure
        assertEquals(1, newUniversity.getFaculties().size(), "Number of faculties does not match");
        assertEquals(1, newUniversity.getFaculties().get(0).getDepartments().size(), "Number of departments does not match");
        assertEquals(1, newUniversity.getFaculties().get(0).getDepartments().get(0).getGroups().size(), "Number of groups does not match");
        assertEquals(2, newUniversity.getFaculties().get(0).getDepartments().get(0).getGroups().get(0).getStudents().size(), "Number of students does not match");

        System.out.println("\nTEST PASSED SUCCESSFULLY! Universities are identical.");
    }
}