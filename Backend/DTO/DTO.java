package com.example.demo.DTO;

public class DTO {
    private String name;
    private String username;
    private String password;
    private String std;
	public DTO(String name, String username, String password, String std) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.std = std;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
    
    
}

