package com.example.demo.Controller;

import jakarta.servlet.http.HttpSession;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerTeacher(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
    try {
    	User user = userService.login(loginDTO.getUsername(), loginDTO.getPassword());
    Map<String, Object> response = new HashMap<>();
    response.put("id", user.getId());
    response.put("role", user.getRole());
   return ResponseEntity.ok(response);
   } catch (Exception e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
    }


    @PostMapping("/register-student")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
    	if (userService.studentExists(student.getUsername())) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).body("Student already exists");
    		}
    	Student savedStudent = userService.saveStudent(student);
    	return ResponseEntity.ok(savedStudent);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getTeacherById(@PathVariable Long id) {
        Optional<User> teacher = userRepository.findById(id);
        if (teacher.isPresent() && teacher.get().getRole().equalsIgnoreCase("TEACHER")) {
            return ResponseEntity.ok(teacher.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
