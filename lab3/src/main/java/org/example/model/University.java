package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private String name; // University name
    private Human rector;
    private List<Faculty> faculties;

    // Constructor for University
    public University(String name, Human rector) {
        this.name = name;
        this.rector = rector;
        this.faculties = new ArrayList<>();
    }

    // Get the university's name
    public String getName() {
        return name;
    }

    // Get the rector
    public Human getRector() {
        return rector;
    }

    // Get the list of faculties
    public List<Faculty> getFaculties() {
        return faculties;
    }

    // Add a new faculty
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}