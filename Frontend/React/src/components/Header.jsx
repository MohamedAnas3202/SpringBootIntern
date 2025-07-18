import React from 'react';
import { NavLink } from 'react-router-dom';
import './Header.css';

const Header = () => {
  return (
    <header className="header">
      <div className="header-container">
        <h1 className="title">👨‍💼 Employee Management System</h1>
        <nav className="nav">
          <ul className="nav-list">
            <li><NavLink exact to="/" activeClassName="active">Home</NavLink></li>
            <li><NavLink to="/login" activeClassName="active">Login</NavLink></li>
            <li><NavLink to="/register" activeClassName="active">Register</NavLink></li>
            <li><NavLink to="/employee" activeClassName="active">View Employees</NavLink></li>
            <li><NavLink to="/addEmployee" activeClassName="active">Add Employee</NavLink></li>
          </ul>
        </nav>
      </div>
    </header>
  );
};

export default Header;
