import React from "react";
import { Link } from "react-router-dom";
import "./LandingPage.css";

const LandingPage = () => {
  return (
    <div className="landing-container">
      <div className="overlay">
        <h1 className="title">Student Result Management System</h1>
        <p className="subtitle">Track results, monitor performance, and simplify academic management.</p>
        {/* <div className="buttons">
          <Link to="/login-student" className="btn btn-student">Student Login</Link>
          <Link to="/login-teacher" className="btn btn-teacher">Teacher Login</Link>
        </div> */}
      </div>
    </div>
  );
};

export default LandingPage;
