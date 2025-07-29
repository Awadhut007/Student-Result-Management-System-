import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

function Navbar() {
  const navigate = useNavigate();

  const studentUsername = localStorage.getItem('studentUsername');
  const teacherUsername = localStorage.getItem('teacherUsername');

  const handleLogout = () => {
    localStorage.clear();
    navigate('/');
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-3">
      <Link className="navbar-brand" to="/">Student Result System</Link>
      <button
        className="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul className="navbar-nav">
          {studentUsername ? (
            <>
              <li className="nav-item">
                <Link className="nav-link" to="/my-result">My Result</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/performance">Performance</Link>
              </li>
              <li className="nav-item">
                <button className="btn btn-danger nav-link" onClick={handleLogout}>
                  Logout
                </button>
              </li>
            </>
          ) : teacherUsername ? (
            <>
              {/* <li className="nav-item">
                <Link className="nav-link" to="/admin/dashboard">Dashboard</Link>
              </li> */}
              <li className="nav-item">
                <Link className="nav-link" to="/teacher/add-student">Add Student</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/teacher/add-subject">Add Subject</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/teacher/add-result">Add Result</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/teacher/view-results">View Results</Link>
              </li>
              <li className="nav-item">
                <button className="btn btn-danger nav-link" onClick={handleLogout}>
                  Logout
                </button>
              </li>
            </>
          ) : (
            <>
              <li className="nav-item">
                <Link className="nav-link" to="/">Home</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/teacher-login">Teacher Login</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/student-login">Student Login</Link>
              </li>
            </>
          )}
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;
