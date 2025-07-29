import React, { useState } from 'react';
import axios from 'axios';

const AddSubject = () => {
  const [subject, setSubject] = useState('');
  const [std, setStd] = useState('');

  const classOptions = [
    '1st Class','2nd Class','3rd Class','4th class','5th Class','6th class','7th class','8th class','9th class','10th class','11th class','12th class','1st Year Graduation', '2nd Year Graduation', '3rd Year Graduation', 'Final Year Graduation'
  ];

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/subjects/add', {
        name: subject,
        std: std,
      });
      alert('Subject added successfully');
      setSubject('');
      setStd('');
    } catch (err) {
      console.error(err);
      alert('Failed to add subject');
    }
  };

  return (
    <div className="container mt-5">
      <h3>Add Subject</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label>Subject Name</label>
          <input
            type="text"
            className="form-control"
            value={subject}
            onChange={(e) => setSubject(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label>Class/Year</label>
          <select
            className="form-select"
            value={std}
            onChange={(e) => setStd(e.target.value)}
            required
          >
            <option value="">Select Class</option>
            {classOptions.map((c) => (
              <option key={c} value={c}>{c}</option>
            ))}
          </select>
        </div>
        <button type="submit" className="btn btn-primary">Add Subject</button>
      </form>
    </div>
  );
};

export default AddSubject;
