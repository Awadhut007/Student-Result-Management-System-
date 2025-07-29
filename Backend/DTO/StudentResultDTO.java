package com.example.demo.DTO;

import java.util.List;

public class StudentResultDTO {
    private String studentName;
    private List<SubjectMarksDTO> results;

    public StudentResultDTO() {}

    public StudentResultDTO(String studentName, List<SubjectMarksDTO> results) {
        this.studentName = studentName;
        this.results = results;
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<SubjectMarksDTO> getResults() {
		return results;
	}

	public void setResults(List<SubjectMarksDTO> results) {
		this.results = results;
	}

    
}
