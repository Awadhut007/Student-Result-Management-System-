import React from 'react';
import { Navigate } from 'react-router-dom';

const TeacherPrivateRoute = ({ children }) => {
  const role = localStorage.getItem('role');
  return role === 'TEACHER' ? children : <Navigate to="/teacher-login" />;
};

export default TeacherPrivateRoute;