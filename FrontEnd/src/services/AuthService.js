// src/services/AuthService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth'; // Change this if your backend URL differs

const login = async (username, password) => {
  return await axios.post(`${API_URL}/login`, { username, password });
};

export default {
  login,
};
