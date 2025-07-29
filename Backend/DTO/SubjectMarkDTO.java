package com.example.demo.DTO;

public class SubjectMarkDTO {
    private String name;
    private int marks;

    public SubjectMarkDTO(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

