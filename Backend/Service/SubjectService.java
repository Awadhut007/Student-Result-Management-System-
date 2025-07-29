package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Subject;
import com.example.demo.Repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public String addSubject(Subject subject) {
        subjectRepository.save(subject);
        return "Suject added Successfully...!";
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public String updateSubject(Long id, Subject updatedSubject) {
        Subject existing = subjectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subject not found"));

        if (updatedSubject.getName() != null && !updatedSubject.getName().isBlank()) {
            existing.setName(updatedSubject.getName());
        }

        subjectRepository.save(existing);
        return "Subject Updated Successfully...!";
    }


    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
    
    public List<Subject> getSubjectsByClass(String std) {
        return subjectRepository.findByStd(std);
    }
}

