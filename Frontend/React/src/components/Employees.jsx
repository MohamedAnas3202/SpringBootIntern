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

  const fetchEmployees = async () => {
    try {
      const res = await axios.get("http://localhost:8080/employee", {
        headers: { Authorization: `Bearer ${getToken()}` },
      });
      setEmployees(res.data);
      setFilteredEmployees(res.data);
    } catch (err) {
      console.error("Error fetching employees:", err);
      setError("❌ Failed to fetch employee data");
    }
  };

  const handleSearchChange = (e) => {
    const term = e.target.value.toLowerCase();
    setSearch(term);
    const filtered = employees.filter((emp) =>
      emp.name.toLowerCase().includes(term)
    );
    setFilteredEmployees(filtered);
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
      fetchEmployees();
      handleCancelClick();
    } catch (err) {
      console.error("Error updating employee:", err);
      setError("❌ Failed to update employee");
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
      setError("❌ Failed to delete employee");
    }
  };

  return (
    <div style={containerStyle}>
      <h2 style={{ marginBottom: "20px" }}>👥 Employee Management</h2>

      <input
        type="text"
        placeholder="🔍 Search employee..."
        value={search}
        onChange={handleSearchChange}
        style={searchInput}
      />

      {error && <p style={{ color: "red", marginTop: "10px" }}>{error}</p>}

      {filteredEmployees.length === 0 ? (
        <p>No employees found.</p>
      ) : (
        <div style={{ overflowX: "auto" }}>
          <table style={tableStyle}>
            <thead>
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
                        name="name"
                        value={editFormData.name}
                        onChange={handleInputChange}
                        style={inputStyle}
                      />
                    ) : (
                      emp.name
                    )}
                  </td>
                  <td style={tdStyle}>
                    {editEmpId === emp.empId ? (
                      <input
                        name="job"
                        value={editFormData.job}
                        onChange={handleInputChange}
                        style={inputStyle}
                      />
                    ) : (
                      emp.job
                    )}
                  </td>
                  <td style={tdStyle}>
                    {editEmpId === emp.empId ? (
                      <>
                        <button onClick={() => handleSaveClick(emp.empId)} style={btnPrimary}>
                          💾 Save
                        </button>
                        <button onClick={handleCancelClick} style={btnSecondary}>
                          ❌ Cancel
                        </button>
                      </>
                    ) : (
                      <>
                        <button onClick={() => handleEditClick(emp)} style={btnEdit}>
                          ✏️ Edit
                        </button>
                        <button onClick={() => handleDelete(emp.empId)} style={btnDelete}>
                          🗑 Delete
                        </button>
                      </>
                    )}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default Employee;
