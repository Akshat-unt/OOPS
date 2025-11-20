# Student Management System - JDBC Project

A comprehensive Java application demonstrating JDBC (Java Database Connectivity) concepts including database connections, CRUD operations, PreparedStatements, ResultSet handling, and exception handling.

## Project Overview

This project implements a **Student Management System** that allows users to:
- Add new student records
- View all students
- Search students by ID or name
- Update student information
- Delete student records
- View statistics

## JDBC Concepts Covered

✅ **Database Connection Management**
- Establishing connection using DriverManager
- Connection pooling concepts
- Proper connection closing

✅ **CRUD Operations**
- **CREATE**: Insert new student records
- **READ**: Retrieve and display student records
- **UPDATE**: Modify existing student information
- **DELETE**: Remove student records

✅ **Prepared Statements**
- Parameterized queries for security
- Prevention of SQL injection attacks

✅ **ResultSet Handling**
- Iterating through query results
- Extracting data from ResultSet
- ResultSetMetaData usage

✅ **Exception Handling**
- SQLException handling
- Try-catch-finally blocks
- Resource management

✅ **Advanced Features**
- Search functionality
- Statistics and reporting
- Input validation

## Project Structure

```
JDBC_Project/
├── DatabaseConfig.java          # Database configuration constants
├── DatabaseConnection.java     # Connection utility class
├── Student.java                # Student model/entity class
├── StudentDAO.java             # Data Access Object for database operations
├── StudentManagementSystem.java # Main application with menu-driven interface
├── database_setup.sql          # SQL script to create database and table
└── README.md                   # This file
```

## Prerequisites

1. **Java Development Kit (JDK)**
   - JDK 8 or higher
   - Download from: https://www.oracle.com/java/technologies/downloads/

2. **MySQL Database Server**
   - MySQL 5.7 or higher
   - Download from: https://dev.mysql.com/downloads/mysql/

3. **MySQL JDBC Driver**
   - Download `mysql-connector-java-8.0.xx.jar` or higher
   - Download from: https://dev.mysql.com/downloads/connector/j/
   - Place the JAR file in the project directory or add to classpath

## Setup Instructions

### Step 1: Database Setup

1. Start MySQL server
2. Open MySQL command line or MySQL Workbench
3. Run the `database_setup.sql` script:
   ```sql
   source database_setup.sql
   ```
   Or copy-paste the SQL commands directly

### Step 2: Configure Database Connection

Edit `DatabaseConfig.java` and update the following:
```java
public static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
public static final String USER = "root";           // Your MySQL username
public static final String PASS = "password";       // Your MySQL password
```

### Step 3: Compile the Project

**Windows:**
```bash
javac -cp ".;mysql-connector-java-8.0.xx.jar" *.java
```

**Linux/Mac:**
```bash
javac -cp ".:mysql-connector-java-8.0.xx.jar" *.java
```

### Step 4: Run the Application

**Windows:**
```bash
java -cp ".;mysql-connector-j-9.5.0.jar" StudentManagementSystem
```

**Linux/Mac:**
```bash
java -cp ".:mysql-connector-java-8.0.xx.jar" StudentManagementSystem
```

## Usage Guide

### Main Menu Options

1. **Add New Student**
   - Enter student details (ID, Name, Age, Course, Email, Phone)
   - System validates duplicate IDs

2. **Display All Students**
   - Shows all student records in a formatted table
   - Displays total count

3. **Search Student by ID**
   - Enter student ID to find specific record
   - Shows detailed information if found

4. **Search Student by Name**
   - Enter full or partial name
   - Shows all matching records

5. **Update Student Information**
   - Enter student ID
   - Update individual fields (press Enter to keep current value)

6. **Delete Student**
   - Enter student ID
   - Confirmation required before deletion

7. **Display Statistics**
   - Shows total number of students
   - Displays count by course

8. **Exit**
   - Closes database connection and exits

## Database Schema

### Students Table

| Column     | Type         | Constraints           |
|------------|--------------|------------------------|
| id         | INT          | PRIMARY KEY            |
| name       | VARCHAR(100) | NOT NULL               |
| age        | INT          | NOT NULL               |
| course     | VARCHAR(100) | NOT NULL               |
| email      | VARCHAR(100) | UNIQUE                 |
| phone      | VARCHAR(15)  |                        |
| created_at | TIMESTAMP    | DEFAULT CURRENT_TIMESTAMP |

## Features

- ✅ Menu-driven user interface
- ✅ Input validation
- ✅ Error handling and user-friendly messages
- ✅ Formatted table output
- ✅ Search functionality (by ID and name)
- ✅ Statistics and reporting
- ✅ Confirmation prompts for destructive operations
- ✅ Proper resource management (connection closing)

## Troubleshooting

### Connection Error
- Ensure MySQL server is running
- Verify database credentials in `DatabaseConfig.java`
- Check if database `studentdb` exists

### ClassNotFoundException
- Ensure MySQL JDBC driver JAR is in classpath
- Download correct version of mysql-connector-java.jar

### SQLException
- Verify table structure matches the code
- Check database permissions
- Ensure all required columns exist

