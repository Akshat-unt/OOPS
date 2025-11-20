# OOPS Lab Practicals - Java Programs

This repository contains 23 Java programs for OOPS lab practicals (UCS3004).

## Programs List

1. **Program1_Welcome.java** - Print "Welcome To Java"
2. **Program2_Address.java** - Print address using single print and multiple println
3. **Program3_Addition.java** - Addition of 2 numbers using Scanner
4. **Program4_Calculator.java** - Simple calculator (+, -, *, /) using switch case
5. **Program5_MetersToFeet.java** - Convert meters to feet
6. **Program6_QuadraticEquation.java** - Solve quadratic equation ax²+bx+c=0
7. **Program7_Fibonacci.java** - Fibonacci series (recursive and non-recursive)
8. **Program8_MatrixMultiplication.java** - Matrix multiplication (3x3)
9. **Program9_Account.java** - Account class with withdraw() and deposit()
10. **Program10_Inheritance.java** - Inheritance and super keyword
11. **Program11_Polymorphism.java** - Polymorphism using method overloading
12. **Program12_MethodOverriding.java** - Method overriding demonstration
13. **Program13_Package.java** - User-defined package usage
14. **Program14_ExceptionHandling.java** - Exception handling with try-catch
15. **Program15_RunnableThread.java** - Thread implementing Runnable interface
16. **Program16_StudentInterface.java** - Interface Student for PG and UG students
17. **Program17_ThreadExtend.java** - Thread by extending Thread and implementing Runnable
18. **Program18_Collections.java** - ArrayList and Vector implementation
19. **Program19_JDBC_Display.java** - JDBC: Display all records
20. **Program20_JDBC_Insert.java** - JDBC: Insert values
21. **Program21_JDBC_Delete.java** - JDBC: Delete values
22. **Program22_JDBC_DisplayValues.java** - JDBC: Display all values
23. **Program23_GUICalculator.java** - GUI Calculator with Grid Layout

## Compilation and Execution

### Basic Programs (1-12, 14-18)
```bash
javac ProgramX_Filename.java
java ProgramX_Filename
```

### Program 13 (Package)
```bash
# Compile the package first
javac mypackage/Student.java

# Then compile and run the main program
javac Program13_Package.java
java Program13_Package
```

### JDBC Programs (19-22)
**Prerequisites:**
- MySQL database server installed and running
- MySQL JDBC driver (mysql-connector-java.jar) downloaded
- Database and table created

**Setup:**
1. Create a database:
```sql
CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100)
);
```

2. Update connection parameters in JDBC programs:
   - `DB_URL`: Database connection URL
   - `USER`: Database username
   - `PASS`: Database password
   - `TABLE_NAME`: Table name

3. Compile with JDBC driver:
```bash
javac -cp ".:mysql-connector-java.jar" ProgramX_JDBC_*.java
java -cp ".:mysql-connector-java.jar" ProgramX_JDBC_*
```

### GUI Calculator (Program 23)
```bash
javac Program23_GUICalculator.java
java Program23_GUICalculator
```

## Notes

- All programs are standalone and can be compiled individually
- Programs 19-22 require MySQL database setup and JDBC driver
- Program 13 requires the `mypackage` directory structure
- Make sure Java JDK is installed (JDK 8 or higher recommended)

## Directory Structure

```
OOPS/
├── Program1_Welcome.java
├── Program2_Address.java
├── Program3_Addition.java
├── Program4_Calculator.java
├── Program5_MetersToFeet.java
├── Program6_QuadraticEquation.java
├── Program7_Fibonacci.java
├── Program8_MatrixMultiplication.java
├── Program9_Account.java
├── Program10_Inheritance.java
├── Program11_Polymorphism.java
├── Program12_MethodOverriding.java
├── mypackage/
│   └── Student.java
├── Program13_Package.java
├── Program14_ExceptionHandling.java
├── Program15_RunnableThread.java
├── Program16_StudentInterface.java
├── Program17_ThreadExtend.java
├── Program18_Collections.java
├── Program19_JDBC_Display.java
├── Program20_JDBC_Insert.java
├── Program21_JDBC_Delete.java
├── Program22_JDBC_DisplayValues.java
├── Program23_GUICalculator.java
└── README.md
```

