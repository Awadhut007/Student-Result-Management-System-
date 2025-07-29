package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private StudentRepository studentRepository;

    public User register(User user) {
        user.setRole("TEACHER"); // force role
        return userRepository.save(user);
    }

    public User login(String username, String password) {
    	Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
    	if (user.isPresent()) {
    	return user.get();
    	} else {
    	throw new RuntimeException("Invalid credentials");
    	}
    	}

    public boolean studentExists(String username) {
        return studentRepository.existsByUsername(username);
    }
    
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
//    public String createStudent(Student student) {
//        student.setRole("STUDENT");
//        studentRepository.save(student);
//        return "Student added Successfully...!";
//    }

}
