package com.example.demo.DTO;

public class ResultResponseDTO {

    private Long id;
    private String studentName;
    private String std;
    private String subjectName;
    private Long marks;
    private String grade;

    public ResultResponseDTO(Long id, String studentName, String std, String subjectName, Long marks, String grade) {
        this.id = id;
        this.studentName = studentName;
        this.std = std;
        this.subjectName = subjectName;
        this.marks = marks;
        this.grade = grade;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
