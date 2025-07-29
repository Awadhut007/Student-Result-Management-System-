// src/pages/MyResultPage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const MyResultPage = () => {
  const [results, setResults] = useState([]);
  const [studentName, setStudentName] = useState('');
  const studentId = localStorage.getItem('studentId');
  const studentUsername = localStorage.getItem('studentUsername');
  const studentNameFromStorage = localStorage.getItem('studentName');

  useEffect(() => {
    if (studentId) {
      setStudentName(studentNameFromStorage);
      axios.get(`http://localhost:8080/api/results/${studentId}`)
        .then(response => {
          setResults(response.data);
        })
        .catch(error => {
          console.error("Error fetching results", error);
        });
    }
  }, [studentId]);

  return (
    <div className="container mt-4">
      <h3>My Results</h3>
      {results.length === 0 ? (
        <p>No results available.</p>
      ) : (
        <table className="table table-bordered">
          <thead className="thead-dark">
            <tr>
              <th>Subject</th>
              <th>Marks</th>
              <th>Grade</th>
            </tr>
          </thead>
          <tbody>
            {results.map((result, index) => (
              <tr key={index}>
                <td>{result.subjectName}</td>
                <td>{result.marks}</td>
                <td>{result.grade}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default MyResultPage;
