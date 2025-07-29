import React, { useEffect, useState } from "react";
import axios from "axios";

const TeacherWelcomePage = () => {
  const [teacherName, setTeacherName] = useState("");

  useEffect(() => {
    const teacherId = localStorage.getItem("teacherId");

    const fetchTeacher = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/auth/${teacherId}`);
        setTeacherName(response.data.username); // or .name if your field is named differently
      } catch (error) {
        console.error("Failed to fetch teacher details:", error);
        setTeacherName("Unknown");
      }
    };

    if (teacherId) {
      fetchTeacher();
    }
  }, []);

  return (
    <div className="container mt-5 text-center">
      <h2>Welcome, {teacherName ? teacherName : "Guest"}</h2>
    </div>
  );
};

export default TeacherWelcomePage;
