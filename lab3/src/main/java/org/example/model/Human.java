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
}