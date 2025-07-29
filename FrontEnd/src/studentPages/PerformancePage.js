// src/pages/PerformancePage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Bar } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  BarElement,
  CategoryScale,
  LinearScale,
  Tooltip,
  Legend
} from 'chart.js';

ChartJS.register(BarElement, CategoryScale, LinearScale, Tooltip, Legend);

const PerformancePage = () => {
  const [chartData, setChartData] = useState(null);
  const studentId = localStorage.getItem('studentId');
  const studentName = localStorage.getItem('studentName');

  useEffect(() => {
    if (studentId) {
      axios.get(`http://localhost:8080/api/results/${studentId}`)
        .then(response => {
          const resultData = response.data;
          const labels = resultData.map(result => result.subjectName);
          const marks = resultData.map(result => result.marks);

          setChartData({
            labels: labels,
            datasets: [
              {
                label: 'Marks',
                data: marks,
                backgroundColor: 'rgba(75, 192, 192, 0.7)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
              }
            ]
          });
        })
        .catch(error => {
          console.error('Error fetching performance data', error);
        });
    }
  }, [studentId]);

  return (
    <div className="container mt-4">
      <h2>Performance Graph</h2>
      <h4>{studentName}</h4>
      {chartData ? (
        <Bar data={chartData} options={{ responsive: true }} />
      ) : (
        <p>Loading performance data...</p>
      )}
    </div>
  );
};

export default PerformancePage;
