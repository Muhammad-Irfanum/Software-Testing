package com.example.tdd;

import java.util.ArrayList;
import java.util.List;

public class TestStudentRepository implements StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void clearStudents() {
        students.clear();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
}
