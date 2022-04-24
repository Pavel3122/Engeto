package com.engeto.lekce08UkolOop;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class SchoolClass {
    private String name;
    private int schoolYear;
    private Teacher teacher;
    private ArrayList<Student> students;

    public SchoolClass(String name, int schoolYear, Teacher teacher, ArrayList<Student> students) {
        this.name = name;
        this.schoolYear = schoolYear;
        this.teacher = teacher;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String toString(SchoolClassFormat format) {
        String str = "";
        switch (format) {
            case FIRST:
                str = "####################################\n" +
                        "Třída: " + this.name + " (ročník: " + this.schoolYear + ")\n" +
                        "Třídní učitel: " + this.getTeacher().getLastName() + ", " + this.getTeacher().getFirstName() + "\n" +
                        "Počet studentů: " + this.students.size() + "\n\n" +
                        "####################################\n";
                Integer i = 0;
                for (Student student : students) {
                    str += "# "+ i + " # " + student.getIdAsString() + " - " +
                            student.getFullName() + " (" + student.getYearOfBirth() + ")\n";
                    i++;
                }
                break;
            case SECOND:
                str = this.name + ", " + this.getTeacher().getFullName() + "\n";

                for (Student student : students) {
                    str += student.getIdAsString() + ", " + student.getFullName() + "\n";
                }
                break;
            case THIRD:
                str = "Třída: " + this.name + ", Školní ročník: " + this.schoolYear + "\n" +
                        "Třídní učitel: " + this.getTeacher().getFullName() + "\n" +
                        "Počet studentů: " + this.students.size() + "\n";

                for (Student student : students) {
                    str += student.getIdAsString() + ", " + student.getFullName() + "\n";
                }
                break;

            default:
                throw new InputMismatchException("SchoolClassFormat not recognized");
        }
        return str;
    }

    public void writeToFile(String filePath, SchoolClassFormat format) {
        try {
            File fout = new File(filePath);
            FileOutputStream fos = new FileOutputStream(fout);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(this.toString(format));
            osw.close();
            System.out.println("Writing SchoolClass to file '" + filePath + "' successful");
        } catch (FileNotFoundException e) {
            System.out.println("Chyba zaápisu do cílového adresáře: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Chyba výstupního zápisu: " + e.getMessage());
        }

    }
}
