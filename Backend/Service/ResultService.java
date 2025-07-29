package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ResultDTO;
import com.example.demo.DTO.ResultDTO1;
import com.example.demo.DTO.ResultResponseDTO;
import com.example.demo.Entity.Result;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.Subject;
import com.example.demo.Repository.ResultRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.SubjectRepository;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Result addResult(ResultDTO dto) {
        Student student = studentRepository.findById((long) dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Subject subject = subjectRepository.findById((long) dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        String grade = calculateGrade(dto.getMarks().longValue());

        Result result = new Result();
        result.setStudent(student);
        result.setSubject(subject);
        result.setMarks(dto.getMarks());
        result.setGrade(grade);
        result.setStd(student.getStd()); // 💡 Set class from student entity

        return resultRepository.save(result);
    }

    private String calculateGrade(Long marks) {
        if (marks >= 90 && marks <=100) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else if (marks >= 35) return "P";
        else return "F";
    }

    public List<ResultResponseDTO> getAllResults() {
        List<Result> results = resultRepository.findAll();

        return results.stream().map(result -> new ResultResponseDTO(
        	    result.getId(),
        	    result.getStudent().getName(),
        	    result.getStudent().getStd(), // <-- newly added
        	    result.getSubject().getName(),
        	    result.getMarks(),
        	    result.getGrade()
        	)).collect(Collectors.toList());

    }
    
    public List<ResultDTO1> getResultsByStudentId(Long studentId) {
        List<Result> results = resultRepository.findByStudentId(studentId);
        List<ResultDTO1> dtoList = new ArrayList<>();

        for (Result result : results) {
            String studentName = result.getStudent().getName();
            String subjectName = result.getSubject().getName();
            Long marks = result.getMarks();
            String grade = calculateGrade(marks);

            dtoList.add(new ResultDTO1(studentName, subjectName, marks, grade));
        }

        return dtoList;
    }
    
    public List<ResultResponseDTO> getResultsByClass(String std) {
        List<Result> results = resultRepository.findByStd(std);
        return results.stream().map(result -> new ResultResponseDTO(
                result.getId(),
                result.getStudent().getName(),
                result.getStudent().getStd(),
                result.getSubject().getName(),
                result.getMarks(),
                result.getGrade()
        )).collect(Collectors.toList());
    }
    


}
