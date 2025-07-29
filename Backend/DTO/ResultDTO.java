package com.example.demo.DTO;

public class ResultDTO {
	
    private Long subjectId;
    private Long studentId;
    private Long marks;
    private String grade;
	public ResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultDTO(Long subjectId, Long studentId, Long marks, String grade) {
		super();
		this.subjectId = subjectId;
		this.studentId = studentId;
		this.marks = marks;
		this.grade = grade;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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