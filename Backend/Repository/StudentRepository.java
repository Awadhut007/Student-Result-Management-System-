package com.example.demo.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
    boolean existsByUsername(String username);
    List<Student> findByStd(String std);
    public Student findByUsernameAndPassword(String username, String password);
}

