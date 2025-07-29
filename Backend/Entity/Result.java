package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long marks;
    private String grade;
    private String std;

    // Many results can belong to one student
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
//    @JsonBackReference
    private Student student;

    // Many results can belong to one subject
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Result() {
    }

    public Result(Long marks, String grade, String std, Student student, Subject subject) {
        this.marks = marks;
        this.grade = grade;
        this.std = std;
        this.student = student;
        this.subject = subject;
    }


    public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	// Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

