import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './nav/Navbar';
import TeacherLoginPage from './components/TeacherLoginPage';
import StudentLoginPage from './components/StudentLoginPage';
import StudentWelcomePage from './StudentPages/StudentWelcomePage';
import MyResultPage from './StudentPages/MyResultPage';
import PerformancePage from './StudentPages/PerformancePage';
import TeacherWelcomePage from './TeacherPages/TeacherWelcomePage';
import AddStudentPage from './TeacherPages/AddStudentPage';
import AddSubjectPage from './TeacherPages/AddSubjectPage';
import AddResultPage from './TeacherPages/AddResultPage';
import GroupedResultsPage from './TeacherPages/GroupedResultsPage';
import Register from './components/Register';
import LandingPage from './components/LandingPage';
import TeacherPrivateRoute from './PrivateRoute/TeacherPrivateRoute';
import StudentPrivateRoute from './PrivateRoute/StudentPrivateRoute';



function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/register" element={<Register />} />

        {/* Teacher Login */}
        <Route path="/teacher-login" element={<TeacherLoginPage />} />
        
        {/* Protected Teacher Routes */}
        <Route
          path="/teacher/welcome"
          element={
            <TeacherPrivateRoute>
              <TeacherWelcomePage />
            </TeacherPrivateRoute>
          }
        />
        <Route
          path="/teacher/add-student"
          element={
            <TeacherPrivateRoute>
              <AddStudentPage />
            </TeacherPrivateRoute>
          }
        />
        <Route
          path="/teacher/add-subject"
          element={
            <TeacherPrivateRoute>
              <AddSubjectPage />
            </TeacherPrivateRoute>
          }
        />
        <Route
          path="/teacher/add-result"
          element={
            <TeacherPrivateRoute>
              <AddResultPage />
            </TeacherPrivateRoute>
          }
        />
        <Route
          path="/teacher/view-results"
          element={
            <TeacherPrivateRoute>
              <GroupedResultsPage />
            </TeacherPrivateRoute>
          }
        />

        {/* Student Login */}
        <Route path="/student-login" element={<StudentLoginPage />} />

        {/* Protected Student Routes */}
        <Route
          path="/student/welcome"
          element={
            <StudentPrivateRoute>
              <StudentWelcomePage />
            </StudentPrivateRoute>
          }
        />
        <Route
          path="/my-result"
          element={
            <StudentPrivateRoute>
              <MyResultPage />
            </StudentPrivateRoute>
          }
        />
        <Route
          path="/performance"
          element={
            <StudentPrivateRoute>
              <PerformancePage />
            </StudentPrivateRoute>
          }
        />
      </Routes>
    </Router>
  );
}

export default App;
