package org.example.model;

import java.util.Objects;

public class Human {
    protected String lastName;
    protected String firstName;
    protected String middleName;
    protected Gender gender;

    // Constructor for Human
    public Human(String firstName, String lastName, String middleName, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
    }

    // Get for attributes
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Gender getGender() {
        return gender;
    }

    // Get full name in classic format
    public String getFullName() {
        return String.format("%s %s %s", lastName, firstName, middleName);
    }

    // Override toString() for convenient output
    @Override
    public String toString() {
        return String.format("%s %s %s (%s)", lastName, firstName, middleName, gender);
    }

    // Override equals() for accurate object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(lastName, human.lastName) &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(middleName, human.middleName) &&
                gender == human.gender;
    }

    // Override hashCode() for efficient use in collections
    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, gender);
    }
}