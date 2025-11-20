@echo off
echo Running Student Management System...
echo.

REM Update the JAR filename according to your MySQL connector version
java -cp ".;mysql-connector-java-8.0.33.jar" StudentManagementSystem

pause

