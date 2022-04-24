package com.engeto.lekce08UkolOop;

public class Student extends Person {
    private Integer yearOfBirth;
    private Integer idNum;

    public Student(String firstName, String lastName, Integer yearOfBirth, Integer idNum) {
        super(firstName, lastName);
        this.yearOfBirth = yearOfBirth;
        this.idNum = idNum;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getIdNum() {
        return idNum;
    }

    public void setIdNum(Integer idNum) {
        this.idNum = idNum;
    }

    @Override
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getIdAsString() {
        return "ID" + String.format("%03d", this.idNum);
    }
}
