-- Database Setup Script for Student Management System
-- Run this script in MySQL to create the database and table

-- Create database
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

-- Create students table
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data (optional)
INSERT INTO students (id, name, age, course, email, phone) VALUES
(101, 'John Doe', 20, 'Computer Science', 'john.doe@example.com', '1234567890'),
(102, 'Jane Smith', 21, 'Information Technology', 'jane.smith@example.com', '2345678901'),
(103, 'Bob Johnson', 19, 'Computer Science', 'bob.johnson@example.com', '3456789012'),
(104, 'Alice Williams', 22, 'Electronics', 'alice.williams@example.com', '4567890123'),
(105, 'Charlie Brown', 20, 'Mechanical Engineering', 'charlie.brown@example.com', '5678901234');

-- Display table structure
DESCRIBE students;

-- Display all records
SELECT * FROM students;

