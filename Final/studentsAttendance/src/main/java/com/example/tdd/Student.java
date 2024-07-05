package com.example.tdd;

import java.time.LocalTime;

public class Student {
    private String name;
    private LocalTime arrivalTime;

    public Student(String name, LocalTime arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
}
