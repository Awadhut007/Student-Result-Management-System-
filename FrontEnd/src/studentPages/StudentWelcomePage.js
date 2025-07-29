import React, { useEffect, useState } from "react";
import axios from "axios";

const StudentWelcome = () => {
  const [student, setStudent] = useState(null);

  // Fetch username from localStorage (assuming it was saved during login)
  const username = localStorage.getItem("studentUsername");

  useEffect(() => {
    if (username) {
      axios
        .get(`http://localhost:8080/api/students/username/${username}`)
        .then((response) => {
          setStudent(response.data);
        })
        .catch((error) => {
          console.error("Error fetching student data:", error);
        });
    }
  }, [username]);

  return (
    <div className="container mt-5">
      <h2>Welcome, {student ? student.name : "Student"} 👋</h2>

      {student && (
        <div className="card mt-4 p-4 shadow rounded">
          <h5 className="mb-3">Your Details:</h5>
          <p><strong>Student ID:</strong> {student.id}</p>
          <p><strong>Name:</strong> {student.name}</p>
          <p><strong>Email:</strong> {student.email}</p>
          <p><strong>Class:</strong> {student.std}</p>
        </div>
      )}
    </div>
  );
};

export default StudentWelcome;
