import React from 'react';
import { Navigate } from 'react-router-dom';

const StudentPrivateRoute = ({ children }) => {
  const role = localStorage.getItem('role');
  return role === 'STUDENT' ? children : <Navigate to="/student-login" />;
};

export default StudentPrivateRoute;