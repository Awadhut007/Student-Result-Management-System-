package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String updateStudent(Long id, Student updatedData) {
        Student existing = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        // Update only if value is not null (and optionally, not blank)
        if (updatedData.getName() != null && !updatedData.getName().isBlank()) {
            existing.setName(updatedData.getName());
        }
        if (updatedData.getEmail() != null && !updatedData.getEmail().isBlank()) {
            existing.setEmail(updatedData.getEmail());
        }
        if (updatedData.getPassword() != null && !updatedData.getPassword().isBlank()) {
            existing.setPassword(updatedData.getPassword());
        }

        studentRepository.save(existing);
        return "Student Updated Successfully...!";
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Student findByUsernameAndPassword(String username, String password) {
        return studentRepository.findByUsernameAndPassword(username, password);
    }
    
    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

}

