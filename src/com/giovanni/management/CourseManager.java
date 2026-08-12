package com.giovanni.management;

import java.util.ArrayList;
import java.util.List;

public class CourseManager implements CourseRepository {
    private final String courseName;
    private final List<Student> students;

    public CourseManager(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Lo studente non può essere null.");
        }
        students.add(student);
    }

    @Override
    public void removeStudent(String studentId) throws StudentNotFoundException {
        boolean removed = students.removeIf(s -> s.getId().equalsIgnoreCase(studentId));
        if (!removed) {
            throw new StudentNotFoundException("Impossibile rimuovere: Matricola " + studentId + " non trovata.");
        }
    }

    @Override
    public Student findStudentById(String studentId) throws StudentNotFoundException {
        return students.stream()
                .filter(s -> s.getId().equalsIgnoreCase(studentId))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Studente con matricola " + studentId + " non trovato."));
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public List<Student> getTopStudents(double minGpa) {
        return students.stream()
                .filter(s -> s.getGpa() >= minGpa)
                .toList();
    }

    public String getCourseName() {
        return courseName;
    }
}