package com.engeto.lekce08UkolOop;

public class Teacher extends Person{
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
