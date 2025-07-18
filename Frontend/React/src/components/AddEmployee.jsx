import { useState } from "react";
import axios from "axios";
import "./AddEmployee.css"; // Create this CSS file for styling

const AddEmployee = () => {
  const [empID, setEmpID] = useState("");
  const [name, setName] = useState("");
  const [job, setJob] = useState("");

  const resetForm = () => {
    setEmpID("");
    setName("");
    setJob("");
  };

  const getToken = () => localStorage.getItem("token");

  const handleAddEmployee = async (e) => {
    e.preventDefault();

    // Validation
    if (!empID || !name || !job) {
      alert("Please fill all fields.");
      return;
    }

    try {
      const response = await axios.post(
        "http://localhost:8080/employee",
        {
          empId: Number(empID),
          name: name.trim(),
          job: job.trim(),
        },
        {
          headers: {
            Authorization: `Bearer ${getToken()}`,
          },
        }
      );

      alert("✅ Employee Added Successfully!");
      resetForm();
    } catch (err) {
      console.error("❌ Failed Adding Employee:", err);
      alert("❌ Adding Employee Failed");
    }
  };

  return (
    <div className="add-employee-container">
      <h2 className="form-title">Add New Employee</h2>
      <form onSubmit={handleAddEmployee} className="employee-form">
        <div className="form-group">
          <label htmlFor="empID">Employee ID</label>
          <input
            id="empID"
            type="number"
            value={empID}
            onChange={(e) => setEmpID(e.target.value)}
            placeholder="Enter Employee ID"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="name">Employee Name</label>
          <input
            id="name"
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter Name"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="job">Job Role</label>
          <input
            id="job"
            type="text"
            value={job}
            onChange={(e) => setJob(e.target.value)}
            placeholder="Enter Job Title"
            required
          />
        </div>

        <button type="submit" className="submit-btn">
          ➕ Add Employee
        </button>
      </form>
    </div>
  );
};

export default AddEmployee;
