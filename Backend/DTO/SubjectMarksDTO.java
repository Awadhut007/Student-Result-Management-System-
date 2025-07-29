package com.example.demo.DTO;

public class SubjectMarksDTO {
    private String subjectName;
    private int marks;
    private String grade;

    public SubjectMarksDTO() {}

    public SubjectMarksDTO(String subjectName, int marks, String grade) {
        this.subjectName = subjectName;
        this.marks = marks;
        this.grade = grade;
    }

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

    
}
