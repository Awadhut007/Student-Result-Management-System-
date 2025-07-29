package com.example.demo.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.StudeDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentService;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentRepository studentRepository;

    // Add student
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student, HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        studentService.addStudent(student);
        return ResponseEntity.ok("Student added");
    }

    // View all students
    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
  List<StudentDTO> studentDTOs = studentRepository.findAll()
  .stream().map(student -> new StudentDTO(student.getId(), student.getName())).collect(Collectors.toList());
    return ResponseEntity.ok(studentDTOs);
    }




    // Update student
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student, HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        studentService.updateStudent(id, student);
        return ResponseEntity.ok("Student updated");
    }

    // Delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted");
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(@RequestBody LoginDTO loginRequest) {
        Student student = studentService.findByUsernameAndPassword(
            loginRequest.getUsername(), loginRequest.getPassword());

        if (student != null) {
            // Return full student info (id, username, name)
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    
    @GetMapping("/by-class/{std}")
    public List<Student> getStudentsByClass(@PathVariable String std) {
        return studentRepository.findByStd(std);
    }
    
    @GetMapping("/username/{username}")
    public StudeDTO getStudentByUsername(@PathVariable String username) {
        Student student = studentService.findByUsername(username);
        if (student == null) return null;

        StudeDTO dto = new StudeDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setStd(student.getStd());

        return dto;
    }


}

