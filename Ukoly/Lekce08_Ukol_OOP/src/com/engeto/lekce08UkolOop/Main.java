package com.engeto.lekce08UkolOop;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Petr", "Svoboda", 2011, 001));
        students.add(new Student("Milan", "Říha", 2010, 123));
        students.add(new Student("Jindřich", "Nový", 2012, 345));

        Teacher teacher = new Teacher("Jan", "Novák");

        SchoolClass schoolClass = new SchoolClass("4.C", 4, teacher, students);

        System.out.println("\nPrinting SchoolClass in first format:");
        System.out.println(schoolClass.toString(SchoolClassFormat.FIRST));

        System.out.println("\nPrinting SchoolClass in second format:");
        System.out.println(schoolClass.toString(SchoolClassFormat.SECOND));

        System.out.println("\nPrinting SchoolClass in third format:");
        System.out.println(schoolClass.toString(SchoolClassFormat.THIRD));

        System.out.println("Writing SchoolClass to file:");
        schoolClass.writeToFile("src/com/engeto/lekce08UkolOop/schoolClass.txt", SchoolClassFormat.FIRST);
    }
}
