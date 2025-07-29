package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	 List<Subject> findByStd(String std);
}
