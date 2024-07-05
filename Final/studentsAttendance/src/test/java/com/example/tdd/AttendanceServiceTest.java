package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

public class AttendanceServiceTest {

    private AttendanceService attendanceService;
    private TestStudentRepository testStudentRepository;

    @BeforeEach
    public void setUp() {
        testStudentRepository = new TestStudentRepository();
        testStudentRepository.addStudent(new Student("Alice", LocalTime.of(8, 5)));
        testStudentRepository.addStudent(new Student("Bob", LocalTime.of(8, 15)));
        testStudentRepository.addStudent(new Student("Charlie", LocalTime.of(8, 25)));

        attendanceService = new AttendanceService(testStudentRepository);
    }

    @Test
    public void testFindLateStudents() {
        List<Student> lateStudents = attendanceService.findLateStudents(LocalTime.of(8, 0));
        Assertions.assertEquals(2, lateStudents.size());
        Assertions.assertTrue(lateStudents.stream().anyMatch(student -> student.getName().equals("Bob")));
        Assertions.assertTrue(lateStudents.stream().anyMatch(student -> student.getName().equals("Charlie")));
    }

    @Test
    public void testFindLateStudents_NoLateStudents() {
        List<Student> lateStudents = attendanceService.findLateStudents(LocalTime.of(8, 30));
        Assertions.assertTrue(lateStudents.isEmpty());
    }

    @Test
    public void testFindLateStudents_EmptyRepository() {
        testStudentRepository.clearStudents();
        List<Student> lateStudents = attendanceService.findLateStudents(LocalTime.of(8, 0));
        Assertions.assertTrue(lateStudents.isEmpty());
    }

    @Test
    public void testFindLateStudents_ExactlyAtThreshold() {
        LocalTime threshold = LocalTime.of(8, 15);
        List<Student> lateStudents = attendanceService.findLateStudents(threshold);
        Assertions.assertEquals(1, lateStudents.size());
        Assertions.assertTrue(lateStudents.stream().anyMatch(student -> student.getName().equals("Charlie")));
    }

    @Test
    public void testFindLateStudents_JustBeforeThreshold() {
        LocalTime threshold = LocalTime.of(8, 14);
        List<Student> lateStudents = attendanceService.findLateStudents(threshold);
        Assertions.assertEquals(2, lateStudents.size());
        Assertions.assertTrue(lateStudents.stream().anyMatch(student -> student.getName().equals("Bob")));
        Assertions.assertTrue(lateStudents.stream().anyMatch(student -> student.getName().equals("Charlie")));
    }
}
