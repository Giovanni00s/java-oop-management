package com.giovanni.management;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String name;
    private final String surname;
    private double gpa;

    public Student(String id, String name, String surname, double gpa) {
        if (gpa < 18.0 || gpa > 30.0) {
            throw new IllegalArgumentException("La media voti deve essere compresa tra 18 e 30.");
        }
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gpa = gpa;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public double getGpa() { return gpa; }

    public void setGpa(double gpa) {
        if (gpa < 18.0 || gpa > 30.0) {
            throw new IllegalArgumentException("Voto non valido.");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Studente [Matricola: %s, Nome: %s %s, Media Voti: %.2f]", id, name, surname, gpa);
    }
}
