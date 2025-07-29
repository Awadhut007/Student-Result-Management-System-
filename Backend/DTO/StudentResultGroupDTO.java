package com.example.demo.DTO;

import java.util.List;

public class StudentResultGroupDTO {
    private String studentName;
    private List<ResultDTO> results;

    public StudentResultGroupDTO() {}

    public StudentResultGroupDTO(String studentName, List<ResultDTO> results) {
        this.studentName = studentName;
        this.results = results;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<ResultDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultDTO> results) {
        this.results = results;
    }
}
