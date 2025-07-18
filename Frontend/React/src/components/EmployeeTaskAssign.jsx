// src/components/EmployeeTaskAssign.jsx
import React, { useState } from "react";
import "./EmployeeTaskAssign.css";

const EmployeeTaskAssign = () => {
  const [taskAssignments, setTaskAssignments] = useState([]);
  const [employeeName, setEmployeeName] = useState("");
  const [task, setTask] = useState("");

  const handleAssignTask = () => {
    if (employeeName.trim() && task.trim()) {
      const newTask = {
        id: Date.now(),
        employeeName,
        task,
      };
      setTaskAssignments([...taskAssignments, newTask]);
      setEmployeeName("");
      setTask("");
    }
  };

  const handleDeleteTask = (id) => {
    setTaskAssignments(taskAssignments.filter((t) => t.id !== id));
  };

  return (
    <div className="task-assign">
      <h2>📝 Assign Task to Employee</h2>
      <input
        type="text"
        placeholder="Employee Name"
        value={employeeName}
        onChange={(e) => setEmployeeName(e.target.value)}
        className="input"
      />
      <input
        type="text"
        placeholder="Task"
        value={task}
        onChange={(e) => setTask(e.target.value)}
        className="input"
      />
      <button onClick={handleAssignTask} className="assign-btn">
        ✅ Assign Task
      </button>

      <ul className="task-list">
        {taskAssignments.map((item) => (
          <li key={item.id} className="task-item">
            <div>
              <strong>{item.employeeName}</strong> → {item.task}
            </div>
            <button onClick={() => handleDeleteTask(item.id)}>🗑️</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EmployeeTaskAssign;
