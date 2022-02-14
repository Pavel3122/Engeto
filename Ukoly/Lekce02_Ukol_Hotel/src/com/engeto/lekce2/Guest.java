package com.engeto.lekce2;

import java.util.Date;

public class Guest {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Guest(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription () {
        return "First Name: " + this.firstName +
                ", Last Name: " + this.lastName +
                ", Date of Birth: " + this.dateOfBirth.toString();
    }
}
