import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ViewResult = () => {
  const [selectedClass, setSelectedClass] = useState('');
  const [results, setResults] = useState([]);
  const [groupedResults, setGroupedResults] = useState({});

  const classes = [
    "1st Class", "2nd Class", "3rd Class", "4th Class", "5th Class",
    "6th Class", "7th Class", "8th Class", "9th Class", "10th Class",
    "11th Class", "12th Class", '1st Year Graduation', '2nd Year Graduation', '3rd Year Graduation', 'Final Year Graduation'
  ];;

  const fetchResultsByClass = async (cls) => {
    try {
      const response = await axios.get(`http://localhost:8080/api/results/by-class/${cls}`);
      const resultList = response.data;

      const grouped = {};
      resultList.forEach(result => {
        const studentName = result.studentName;
        if (!grouped[studentName]) {
          grouped[studentName] = [];
        }
        grouped[studentName].push(result);
      });

      setGroupedResults(grouped);
      setResults(resultList);
    } catch (error) {
      console.error("Error fetching results:", error);
    }
  };

  const handleClassChange = (e) => {
    const selected = e.target.value;
    setSelectedClass(selected);
    if (selected !== '') {
      fetchResultsByClass(selected);
    }
  };

  return (
    <div className="container mt-4">
      <h3 className="mb-3">View Student Results</h3>

      <div className="mb-3">
        <label className="form-label">Select Class:</label>
        <select className="form-select" value={selectedClass} onChange={handleClassChange}>
          <option value="">-- Select Class --</option>
          {classes.map((cls, index) => (
            <option key={index} value={cls}>{cls}</option>
          ))}
        </select>
      </div>

      {Object.keys(groupedResults).length > 0 ? (
        <div className="mt-4">
          {Object.entries(groupedResults).map(([studentName, subjects], index) => (
            <div key={index} className="card mb-3">
              <div className="card-header bg-secondary text-white">
                <strong>{studentName}</strong>
              </div>
              <ul className="list-group list-group-flush">
                {subjects.map((res, idx) => (
                  <li key={idx} className="list-group-item d-flex justify-content-between">
                    <span>{res.subjectName}</span>
                    <span>Marks: {res.marks}</span>
                    <span>Grade: {res.grade}</span>
                  </li>
                ))}
              </ul>
            </div>
          ))}
        </div>
      ) : selectedClass && results.length === 0 ? (
        <p>No results found for the selected class.</p>
      ) : null}
    </div>
  );
};

export default ViewResult;
