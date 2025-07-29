import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const AddStudent = () => {
  const navigate = useNavigate();
  const [student, setStudent] = useState({
    name: "",
    email: "",
    username: "",
    password: "",
    role:"STUDENT",
    std: "", // Store year of graduation here as string
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent({ ...student, [name]: value });
  };

  const handleSubmit = async (e) => {
  e.preventDefault();
  try {
    await axios.post("http://localhost:8080/api/auth/register-student", student);
    alert("Student added successfully");
    setStudent({
      name: "",
      email: "",
      username: "",
      password: "",
      role: "STUDENT",
      std: "",
    });
  } catch (err) {
    console.error("Error adding student:", err);
    alert("Error adding student");
  }
};


  return (
    <div className="container mt-4">
      <h2>Add Student</h2>
      <form onSubmit={handleSubmit} className="mt-3">
        <div className="form-group mb-3">
          <label>Name</label>
          <input
            type="text"
            className="form-control"
            name="name"
            value={student.name}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group mb-3">
          <label>Email</label>
          <input
            type="email"
            className="form-control"
            name="email"
            value={student.email}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group mb-3">
          <label>Username</label>
          <input
            type="text"
            className="form-control"
            name="username"
            value={student.username}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group mb-3">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            name="password"
            value={student.password}
            onChange={handleChange}
            required
          />
        </div>

       <div className="form-group">
          <label htmlFor="std">Class / Year</label>
          <select
            className="form-control"
            id="std"
            name="std"
            value={student.std}
            onChange={handleChange}
            required
          >
            <option value="">Select Class</option>
            <option value="1st Class">1st Class</option>
            <option value="2nd Class">2nd Class</option>
            <option value="3rd Class">3rd Class</option>
            <option value="4th Class">4th Class</option>
            <option value="5th Class">5th Class</option>
            <option value="6th Class">6th Class</option>
            <option value="7th Class">7th Class</option>
            <option value="8th Class">8th Class</option>
            <option value="9th Class">9th Class</option>
            <option value="10th Class">10th Class</option>
            <option value="11th Class">11th Class</option>
            <option value="12th Class">12th Class</option>
            <option value="1st Year Graduation">1st Year Graduation</option>
            <option value="2nd Year Graduation">2nd Year Graduation</option>
            <option value="3rd Year Graduation">3rd Year Graduation</option>
            <option value="Final Year Graduation">Final Year Graduation</option>
          </select>
        </div>
<br></br>
        <button type="submit" className="btn btn-primary">
          Add Student
        </button>
      </form>
    </div>
  );
};

export default AddStudent;
  