import { useEffect, useState } from "react";
import axios from "axios";

const Employee = () => {
  const [employees, setEmployees] = useState([]);
  const [filteredEmployees, setFilteredEmployees] = useState([]);
  const [search, setSearch] = useState("");
  const [error, setError] = useState("");
  const [editEmpId, setEditEmpId] = useState(null);
  const [editFormData, setEditFormData] = useState({ name: "", job: "" });

  const getToken = () => localStorage.getItem("token");

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = () => {
    axios
      .get("http://localhost:8080/employee", {
        headers: { Authorization: `Bearer ${getToken()}` },
      })
      .then((res) => {
        setEmployees(res.data);
        setFilteredEmployees(res.data);
      })
      .catch((err) => {
        console.error("Error fetching employees:", err);
        setError("Failed to fetch employee data");
      });
  };

  const handleSearchChange = (e) => {
    const term = e.target.value.toLowerCase();
    setSearch(term);
    setFilteredEmployees(
      employees.filter((emp) =>
        emp.name.toLowerCase().includes(term)
      )
    );
  };

  const handleEditClick = (emp) => {
    setEditEmpId(emp.empId);
    setEditFormData({ name: emp.name, job: emp.job });
  };

  const handleCancelClick = () => {
    setEditEmpId(null);
    setEditFormData({ name: "", job: "" });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSaveClick = async (empId) => {
    try {
      await axios.put(
        `http://localhost:8080/employee/${empId}`,
        editFormData,
        {
          headers: { Authorization: `Bearer ${getToken()}` },
        }
      );

      fetchEmployees(); // Refresh from server
      setEditEmpId(null);
      setEditFormData({ name: "", job: "" });
    } catch (err) {
      console.error("Error updating employee:", err);
      setError("Failed to update employee");
    }
  };

  const handleDelete = async (empId) => {
    const confirmDelete = window.confirm("Are you sure you want to delete this employee?");
    if (!confirmDelete) return;

    try {
      await axios.delete(`http://localhost:8080/employee/${empId}`, {
        headers: { Authorization: `Bearer ${getToken()}` },
      });
      fetchEmployees();
    } catch (err) {
      console.error("Error deleting employee:", err);
      setError("Failed to delete employee");
    }
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <h2>🎯 Employee Manager</h2>

      <input
        type="text"
        placeholder="🔍 Search by name"
        value={search}
        onChange={handleSearchChange}
        style={{
          padding: "8px",
          marginBottom: "15px",
          width: "250px",
          borderRadius: "5px",
          border: "1px solid #ccc"
        }}
      />

      {error && <p style={{ color: "red" }}>{error}</p>}

      {filteredEmployees.length === 0 ? (
        <p>No employees found.</p>
      ) : (
        <table style={{
          borderCollapse: "collapse",
          width: "100%",
          boxShadow: "0 0 10px rgba(0,0,0,0.1)"
        }}>
          <thead style={{ backgroundColor: "#f0f0f0" }}>
            <tr>
              <th style={thStyle}>ID</th>
              <th style={thStyle}>Name</th>
              <th style={thStyle}>Job</th>
              <th style={thStyle}>Actions</th>
            </tr>
          </thead>
          <tbody>
            {filteredEmployees.map((emp) => (
              <tr key={emp.empId}>
                <td style={tdStyle}>{emp.empId}</td>
                <td style={tdStyle}>
                  {editEmpId === emp.empId ? (
                    <input
                      type="text"
                      name="name"
                      value={editFormData.name}
                      onChange={handleInputChange}
                    />
                  ) : (
                    emp.name
                  )}
                </td>
                <td style={tdStyle}>
                  {editEmpId === emp.empId ? (
                    <input
                      type="text"
                      name="job"
                      value={editFormData.job}
                      onChange={handleInputChange}
                    />
                  ) : (
                    emp.job
                  )}
                </td>
                <td style={tdStyle}>
                  {editEmpId === emp.empId ? (
                    <>
                      <button onClick={() => handleSaveClick(emp.empId)} style={btnSave}>
                        Save
                      </button>
                      <button onClick={handleCancelClick} style={btnCancel}>
                        Cancel
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditClick(emp)} style={btnEdit}>
                        📝 Edit
                      </button>
                      <button onClick={() => handleDelete(emp.empId)} style={btnDelete}>
                        ❌ Delete
                      </button>
                    </>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

// Styling
const thStyle = {
  padding: "12px",
  border: "1px solid #ddd",
  textAlign: "left",
  backgroundColor: "#f9f9f9"
};

const tdStyle = {
  padding: "10px",
  border: "1px solid #ddd",
};

const btnEdit = {
  padding: "5px 10px",
  marginRight: "5px",
  backgroundColor: "#3498db",
  color: "white",
  border: "none",
  borderRadius: "4px",
  cursor: "pointer"
};

const btnDelete = {
  padding: "5px 10px",
  backgroundColor: "#e74c3c",
  color: "white",
  border: "none",
  borderRadius: "4px",
  cursor: "pointer"
};

const btnSave = {
  padding: "5px 10px",
  backgroundColor: "#2ecc71",
  color: "white",
  border: "none",
  borderRadius: "4px",
  marginRight: "5px",
  cursor: "pointer"
};

const btnCancel = {
  padding: "5px 10px",
  backgroundColor: "#7f8c8d",
  color: "white",
  border: "none",
  borderRadius: "4px",
  cursor: "pointer"
};

export default Employee;
