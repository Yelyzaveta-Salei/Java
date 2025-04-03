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

    // Override toString for detailed output
    @Override
    public String toString() {
        StringBuilder facultiesString = new StringBuilder();
        for (Faculty faculty : faculties) {
            facultiesString.append(faculty.toString()).append("\n");
        }
        return "University{name='" + name + "', rector=" + rector + ", faculties=\n" + facultiesString.toString() + "}";
    }

    // Override equals for accurate object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(rector, that.rector) &&
                Objects.equals(faculties, that.faculties);
    }

    // Override hashCode for consistent hashing
    @Override
    public int hashCode() {
        return Objects.hash(name, rector, faculties);
    }
}