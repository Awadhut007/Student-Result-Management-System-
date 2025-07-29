// src/components/StudentLoginPage.js
import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const StudentLoginPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loginError, setLoginError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/api/students/login", {
        username,
        password,
      });

      const student = response.data;

      // ✅ Save details to localStorage
      localStorage.setItem("studentId", student.id); // for results
      localStorage.setItem("studentUsername", student.username);
      localStorage.setItem("studentName", student.name);
      localStorage.setItem("role", "STUDENT");

      // Redirect to student welcome page
      navigate("/student/welcome");
    } catch (error) {
      alert("Invalid credentials. Please try again.");
    }
  };

  return (
    <div className="container mt-5">
      <h2>Student Login</h2>
      <form onSubmit={handleLogin}>
        <div className="mb-3">
          <label>Username:</label>
          <input
            type="text"
            className="form-control"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>

        <div className="mb-3">
          <label>Password:</label>
          <input
            type="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        {loginError && <div className="alert alert-danger">{loginError}</div>}

        <button type="submit" className="btn btn-primary">Login</button>
      </form>
    </div>
  );
};

export default StudentLoginPage;
