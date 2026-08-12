package com.giovanni.management;

import java.util.List;

public interface CourseRepository {
    void addStudent(Student student);
    void removeStudent(String studentId) throws StudentNotFoundException;
    Student findStudentById(String studentId) throws StudentNotFoundException;
    List<Student> getAllStudents();
    List<Student> getTopStudents(double minGpa);
}