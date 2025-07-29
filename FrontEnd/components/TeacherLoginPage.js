// src/components/TeacherLoginPage.js
import React, { useState } from 'react';
import AuthService from '../services/AuthService';
import { useNavigate } from 'react-router-dom';

const TeacherLoginPage = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await AuthService.login(username, password);
      const user = response.data;

      if (user.role === 'TEACHER') {
        localStorage.setItem('user', JSON.stringify(user));
        localStorage.setItem("teacherUsername", response.data.username);
        localStorage.setItem("teacherId", user.id);
        localStorage.setItem("teacherRole", user.role);
        localStorage.setItem("role", "TEACHER");

        navigate('/teacher/welcome'); // You can change this later
      } else {
        setError('Not authorized as teacher');
      }
    } catch (error) {
      alert('Invalid username or password');
    }
  };

  return (
    <div className="container mt-5">
      <h2>Teacher Login</h2>
      {error && <div className="alert alert-danger">{error}</div>}
      <form onSubmit={handleLogin}>
        <div className="mb-3">
          <label className="form-label">Username:</label>
          <input
            type="text"
            className="form-control"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Password:</label>
          <input
            type="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Login</button>
      </form>
      <div className="mt-3">
        <p>Don't have an account?</p>
        <button
          className="btn btn-outline-primary"
          onClick={() => navigate("/register")}
        >
          Register
        </button>
      </div>
    </div>
  );
};

export default TeacherLoginPage;
