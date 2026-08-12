package com.giovanni.management;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema di Gestione Corso Universitario ===");

        CourseManager oopCourse = new CourseManager("Programmazione Orientata agli Oggetti");


        oopCourse.addStudent(new Student("05121001", "Giovanni", "Sammartino", 28.5));
        oopCourse.addStudent(new Student("05121002", "Mario", "Rossi", 24.0));
        oopCourse.addStudent(new Student("05121003", "Giulia", "Bianchi", 30.0));


        System.out.println("\n--- Lista degli Iscritti al corso " + oopCourse.getCourseName() + " ---");
        oopCourse.getAllStudents().forEach(System.out::println);

        try {
            System.out.println("\n--- Ricerca Studente 05121001 ---");
            Student s = oopCourse.findStudentById("05121001");
            System.out.println("Trovato: " + s);

            System.out.println("\n--- Ricerca Studente Inesistente ---");
            oopCourse.findStudentById("99999999");
        } catch (StudentNotFoundException e) {
            System.err.println("Errore gestito: " + e.getMessage());
        }


        System.out.println("\n--- Studenti con media pari o superiore a 28 ---");
        List<Student> topStudents = oopCourse.getTopStudents(28.0);
        topStudents.forEach(System.out::println);
    }
}