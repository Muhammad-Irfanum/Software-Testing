package com.example.tdd;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private final StudentRepository studentRepository;

    public AttendanceService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findLateStudents(LocalTime threshold) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getArrivalTime().isAfter(threshold))
                .collect(Collectors.toList());
    }
}
