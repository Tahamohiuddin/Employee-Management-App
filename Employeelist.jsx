import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function EmployeeList() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/employees").then((response) => {
      setEmployees(response.data);
    });
  }, []);

  return (
    <div className="container">
      <h2>Employee List</h2>
      <Link to="/add" className="btn btn-primary">Add Employee</Link>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Salary</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.id}>
              <td>{emp.id}</td>
              <td>{emp.name}</td>
              <td>{emp.role}</td>
              <td>${emp.salary.toFixed(2)}</td>
              <td>
                <Link to={`/edit/${emp.id}`} className="btn btn-warning">Edit</Link>
                <button
                  className="btn btn-danger"
                  onClick={() => axios.delete(`http://localhost:8080/api/employees/${emp.id}`).then(() => window.location.reload())}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default EmployeeList;
