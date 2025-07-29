package com.example.demo.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String username; // for login
    private String password;
    private String role;
    private String std;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL , orphanRemoval=true)
    @JsonIgnore
    private List<Result> results;
    
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, String name, String email, String username, String password, String role,
			String std, List<Result> results) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.std=std;
		this.results = results;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}  
	
	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	} 
}

