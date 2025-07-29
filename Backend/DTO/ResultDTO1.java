package com.example.demo.DTO;

public class ResultDTO1 {
    private String studentName;
    private String subjectName;
    private Long marks;
    private String grade;

    public ResultDTO1(String studentName, String subjectName, Long marks, String grade) {
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.marks = marks;
        this.grade = grade;
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

