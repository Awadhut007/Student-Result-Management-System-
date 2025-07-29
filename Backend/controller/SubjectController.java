package com.example.demo.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Subject;
import com.example.demo.Repository.SubjectRepository;
import com.example.demo.Service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/add")
    public String addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSubject(@PathVariable Long id, @RequestBody Subject subject, HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        subjectService.updateSubject(id, subject);
        return ResponseEntity.ok("Subject updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        subjectService.deleteSubject(id);
        return ResponseEntity.ok("Subject deleted");
    }
    
    @GetMapping("/by-class/{std}")
    public List<Subject> getSubjectsByClass(@PathVariable String std) {
        return subjectRepository.findByStd(std);
    }
}
