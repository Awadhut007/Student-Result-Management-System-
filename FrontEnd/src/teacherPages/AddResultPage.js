import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AddResult = () => {
  const classOptions = [
    "1st Class", "2nd Class", "3rd Class", "4th Class", "5th Class",
    "6th Class", "7th Class", "8th Class", "9th Class", "10th Class",
    "11th Class", "12th Class", '1st Year Graduation', '2nd Year Graduation', '3rd Year Graduation', 'Final Year Graduation'
  ];

  const [selectedClass, setSelectedClass] = useState('');
  const [students, setStudents] = useState([]);
  const [subjects, setSubjects] = useState([]);

  const [studentId, setStudentId] = useState('');
  const [subjectId, setSubjectId] = useState('');
  const [marks, setMarks] = useState('');

  const handleClassChange = async (e) => {
    const selected = e.target.value;
    setSelectedClass(selected);
    setStudentId('');
    setSubjectId('');
    setMarks('');
    setSubjects([]);
    try {
      const studentRes = await axios.get(`http://localhost:8080/api/students/by-class/${selected}`);
      setStudents(studentRes.data);
    } catch (err) {
      console.error('Error fetching students:', err);
    }
  };

  const handleStudentChange = async (e) => {
    const selected = e.target.value;
    setStudentId(selected);
    try {
      const subjectRes = await axios.get(`http://localhost:8080/api/subjects/by-class/${selectedClass}`);
      setSubjects(subjectRes.data);
    } catch (err) {
      console.error('Error fetching subjects:', err);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!studentId || !subjectId || !marks) {
      alert("Please fill all fields");
      return;
    }
    if (marks < 0 || marks > 100) {
      alert("Marks should be between 0 and 100");
      return;
    }

    try {
      await axios.post("http://localhost:8080/api/results/add", {
        studentId,
        subjectId,
        marks
      });
      alert("Result added successfully!");
      setMarks('');
      setSubjectId('');
      setStudentId('');
    } catch (err) {
      console.error("Error adding result:", err);
      alert("Error adding result");
    }
  };

  return (
    <div className="container mt-4">
      <h3>Add Student Result</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label>Class</label>
          <select className="form-control" value={selectedClass} onChange={handleClassChange}>
            <option value="">Select Class</option>
            {classOptions.map((cls, index) => (
              <option key={index} value={cls}>{cls}</option>
            ))}
          </select>
        </div>

        <div className="mb-3">
          <label>Student</label>
          <select className="form-control" value={studentId} onChange={handleStudentChange}>
            <option value="">Select Student</option>
            {students.map(student => (
              <option key={student.id} value={student.id}>{student.name}</option>
            ))}
          </select>
        </div>

        <div className="mb-3">
          <label>Subject</label>
          <select className="form-control" value={subjectId} onChange={(e) => setSubjectId(e.target.value)}>
            <option value="">Select Subject</option>
            {subjects.map(subject => (
              <option key={subject.id} value={subject.id}>{subject.name}</option>
            ))}
          </select>
        </div>

        <div className="mb-3">
          <label>Marks</label>
          <input
            type="number"
            className="form-control"
            value={marks}
            onChange={(e) => setMarks(e.target.value)}
            min="0"
            max="100"
          />
        </div>

        <button type="submit" className="btn btn-primary">Add Result</button>
      </form>
    </div>
  );
};

export default AddResult;
